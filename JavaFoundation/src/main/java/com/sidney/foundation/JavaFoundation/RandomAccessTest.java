package com.sidney.foundation.JavaFoundation;

import java.io.DataOutput;
import java.io.*;
public class RandomAccessTest {

	public static void main(String[] args) {
		Employee[] staff = new Employee[3];
		staff [0] = new Employee("Carl", 10000, 1990, 2, 15);
		staff [1] = new Employee("sidney", 12000, 1991, 2, 15);
		staff [2] = new Employee("Jay", 14000, 1992, 2, 15);
		
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	public static void writeData(DataOutput out,Employee e){
		
	}
}
