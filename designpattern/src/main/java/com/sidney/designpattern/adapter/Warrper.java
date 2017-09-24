package com.sidney.designpattern.adapter;

public class Warrper implements Targetable{

	private Source source;
	public Warrper(Source source){
		super();
		this.source = source;
	}
	public void method2() {
		
		System.err.println("This is the targetable method");
	}
	public void method1() {
		
		source.method1();
		
	}
	
	
}
