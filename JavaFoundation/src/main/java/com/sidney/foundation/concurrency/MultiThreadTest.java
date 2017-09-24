package com.sidney.foundation.concurrency;

public class MultiThreadTest {

	public static void main(String[] args) {
	
		Thread d1 = new MyThread();
		d1.start();
		d1.start();
		
		Thread d2  = new Thread(new MyRunnable());
		d2.start();
	}
	
	
	 

}

class MyThread extends Thread{
	
	public void run(){
		try {
			Thread.sleep(5000);
			System.out.println("wake up now ");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}


class MyRunnable implements Runnable{

	public void run() {
		
		try {
			Thread.sleep(5000);
			System.out.println("wake up now,here is My Runnalbe ");
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	
}
