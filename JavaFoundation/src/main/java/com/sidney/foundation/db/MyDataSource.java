package com.sidney.foundation.db;

import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.sql.DataSource;


/** 
 * 编写标准的数据源：
 * 1、实现DataSource 接口
 * 2、获取在实现类的构造方法中批量获取Connection 对象，并将这些Connection 存储
 * 在LinkedList 容器中。
 * 3、实现getConnection() 方法，调用时返回LinkedList容器的Connection对象给用户。
 * @author 贺佐安
 *
 */
public class MyDataSource implements DataSource{
    private static String url = null;
    private static String password = null;
    private static String user = null ;
    private static String DriverClass = null;
    private static int MAX_CONNECTION = 5;
    private static LinkedList<Connection> pool = new LinkedList<Connection>() ;

    //    注册数据库驱动
    static {
        try {  
            ResourceBundle rb = ResourceBundle.getBundle("config") ;
            url = rb.getString("db.url") ; 
            password = rb.getString("db.password") ; 
            user = rb.getString("db.user") ; 
            DriverClass = rb.getString("db.DriverClass") ;
            Class.forName(DriverClass) ;  
            
            //初始化建立数据连接池
            for(int i = 0 ; i < MAX_CONNECTION ; i ++) {
                Connection conn = DriverManager.getConnection(url, user, password) ;
                pool.add(conn) ;
            }
        } catch (Exception e) {
            throw new RuntimeException(e) ;
        }  
    }
    public MyDataSource ()  { 
        
    }
    
    //、从连接池获取连接:通过动态代理
    public Connection getConnection() throws SQLException {
        if (pool.size() > 0) {
            final Connection conn  = pool.remove() ; 
            Connection proxyCon = (Connection) Proxy.newProxyInstance(conn.getClass().getClassLoader(), new Class[]{Connection.class}, 
                    new InvocationHandler() {
                        //策略设计模式：
                        public Object invoke(Object proxy, Method method, Object[] args)
                                throws Throwable {
                            if("close".equals(method.getName())){
                                //谁调用，
                                return pool.add(conn);//当调用close方法时，拦截了，把链接放回池中了
                            }else{
                                return method.invoke(conn, args);
                            } 
                        }
                    });
          return proxyCon ;
        }else {
            throw new RuntimeException("服务器繁忙！"); 
        }
    } 
    
    public int getLength() {
        return pool.size() ;
    }
    
    
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }
    public void setLogWriter(PrintWriter out) throws SQLException {
        
    }
    public void setLoginTimeout(int seconds) throws SQLException {
        
    }
    public int getLoginTimeout() throws SQLException {
        return 0;
    }
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
    public Connection getConnection(String username, String password)
            throws SQLException {
        return null;
    }

	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	} 
}