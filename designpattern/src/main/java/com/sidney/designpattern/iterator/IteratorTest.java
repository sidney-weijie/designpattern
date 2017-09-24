package com.sidney.designpattern.iterator;

public class IteratorTest {

	public static void main(String[] args) {
		Collection collection = new MyCollection();
		
		Iterator it = collection.iterator();
		
		while(it.hasNext()){
			System.err.println(it.next());
		}

	}

}
