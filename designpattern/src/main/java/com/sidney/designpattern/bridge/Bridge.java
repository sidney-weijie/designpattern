package com.sidney.designpattern.bridge;

public class Bridge {
    private Sourceable source;
    public void method(){
    	source.method();
    }
    public Sourceable getSource(){
    	return source;
    }
    public void setSource(Sourceable source){
    	this.source = source;
    }
    
    
}
