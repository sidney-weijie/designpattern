package com.sidney.foundation.db;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

/**
 * 实现JDBC 框架的核心类。
 * 在该类中定义了SQL语句完成的方法；
 * @author 贺佐安
 *
 */
public class  MyJdbcFrame {
    /**
     * javax.sql.DataSource 实例的引用变量
     */
    private DataSource ds = null ;
    /**
     * 将用户指定的DataSource 指定给系统定义的DataSource 实例的引用变量
     * @param ds
     */
    public MyJdbcFrame(DataSource ds ) {
        this.ds = ds ; 
    }
    /**
     * 执行UPDATE、DELETE、INSERT 语句。
     * @param sql 
     * @param obj
     */
    public void update(String sql , Object[] obj) {
        Connection conn = null ; 
        PreparedStatement stmt = null ; 
        try {
            //获取Connection 对象
            conn = ds.getConnection() ;
            stmt = conn.prepareStatement(sql) ; 
            
            // 获取ParameterMetaData 元数据对象。
            ParameterMetaData pmd = stmt.getParameterMetaData() ;
            
            //获取SQL语句中需要设置的参数的个数
            int parameterCount = pmd.getParameterCount() ;
            if (parameterCount > 0) { 
                if (obj == null || obj.length != parameterCount) {
                    throw new MyJdbcFrameException( "parameterCount is error!") ;
                } 
                //设置参数：
                for ( int i = 0 ; i < obj.length ; i++) {
                    stmt.setObject(i+1, obj[i]) ;
                }
            } 
            //执行语句：
            stmt.executeUpdate() ; 
            
        } catch(Exception e ) {
            throw new MyJdbcFrameException(e.getMessage()) ;
        } finally {
            release(stmt, null, conn) ;
        }
    }
    
    public Object query(String sql , Object[] obj , ResultSetHandler rsh) {
        Connection conn = null ; 
        PreparedStatement stmt = null ; 
        ResultSet rs = null ;
        try {
            //获取Connection 对象
            conn = ds.getConnection() ;
            stmt = conn.prepareStatement(sql) ; 
            
            // 获取ParameterMetaData 元数据对象。
            ParameterMetaData pmd = stmt.getParameterMetaData() ;
            
            //获取SQL语句中需要设置的参数的个数
            int parameterCount = pmd.getParameterCount() ;
            System.out.println("parameterCount = " + parameterCount);
            if (obj.length != parameterCount) {
                throw new MyJdbcFrameException( "'" +sql +"' : parameterCount is error!") ;
            } 
            //设置参数：
            for ( int i = 0 ; i < obj.length ; i++) {
                stmt.setObject(i+1, obj[i]) ;
            }
            //执行语句：
            rs = stmt.executeQuery(); 
            
            return rsh.handler(rs);
        } catch(Exception e ) {
        	e.printStackTrace();
            throw new MyJdbcFrameException(e.getMessage()) ;
        } finally {
            release(stmt, null, conn) ;
        } 
    } 
    /**
     * 释放资源
     * @param stmt
     * @param rs
     * @param conn
     */
    public static void release(Statement stmt 
                             , ResultSet rs 
                             , Connection conn) {
        if(rs != null) {
            try {
                rs.close() ;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null ;
        }
        if (stmt != null) { 
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } 
            stmt = null ;
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null ;
        }
    } 
    
}