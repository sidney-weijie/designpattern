package com.sidney.designpattern.observer;

public class MySubject extends AbstraceSubject{

	public void operation() {
		System.err.println("update self!");
		notifyObservers();
		
	}

}
