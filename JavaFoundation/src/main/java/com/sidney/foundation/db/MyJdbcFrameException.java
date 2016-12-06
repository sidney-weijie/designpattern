package com.sidney.foundation.db;

public class MyJdbcFrameException extends RuntimeException {
    public MyJdbcFrameException() {
        super() ; 
    }
    public MyJdbcFrameException(String e) {
        super(e) ;
    }
}