package com.sidney.designpattern.proxy;



public class Proxy implements Sourceable {

	
	private Source source;
	
	public Proxy(){
		super();
		this.source = new Source();
	}
	public void method() {
		
		before();
		
		source.method();
		
		after();
		
	}
	
	private void after(){
		System.err.println("after proxy!");
	}
	
	private void before(){
		System.err.println("before proxy!");
	}

}
