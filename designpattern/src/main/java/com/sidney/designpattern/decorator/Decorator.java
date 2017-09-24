package com.sidney.designpattern.decorator;

public class Decorator implements Sourceable {
    
	private Sourceable source;
	
	public Decorator(Sourceable source){
		super();
		this.source = source;
	}
	public void method() {
		System.err.println("before decorator");
		
		source.method();
		
		System.err.println("after decorator");
	}

}
