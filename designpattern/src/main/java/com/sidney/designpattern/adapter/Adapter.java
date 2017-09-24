package com.sidney.designpattern.adapter;

public class Adapter extends Source implements Targetable {

	public void method2() {
		System.err.println("this is the targetable method!");
		
	}

}
