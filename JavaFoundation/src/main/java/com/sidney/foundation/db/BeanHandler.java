package com.sidney.foundation.db;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * 该类获取ResultSet 结果集中的第一个值，封装到JavaBean中
 * @author 贺佐安
 *
 */
public class BeanHandler implements ResultSetHandler { 
    //获取要封装的JavaBean的字节码
    private Class clazz ;
    public BeanHandler (Class clazz) {
        this.clazz = clazz ;
    }

    public Object handler(ResultSet rs) {
        try {
            if (rs!=null) {
                //1、获取结果集的元数据。
                ResultSetMetaData rsm = rs.getMetaData() ;
                //2、创建JavaBean的实例：
                Object obj = clazz.newInstance() ;
                //3、将数据封装到JavaBean中。  
                for (int i = 0 ; i < rsm.getColumnCount() ; i ++) {
                    //获取属性名
                    String columnName = rsm.getColumnName(i+1) ; 
                    //获取属性值
                    Object value = rs.getObject(i+1) ; 
                    
                    Field objField = obj.getClass().getDeclaredField(columnName) ;
                    objField.setAccessible(true) ;
                    objField.set(obj, value) ;
                }
                return obj ;
            } else {
                return null ;
            }
        } catch (Exception e) {
            throw new RuntimeException(e) ;
        }   
    } 
}