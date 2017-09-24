package com.sidney.designpattern.bridge;

public class MyBridge extends Bridge{

	public void method(){
		getSource().method();
	}
}
