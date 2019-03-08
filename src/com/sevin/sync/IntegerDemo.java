package com.sevin.sync;

public class IntegerDemo {

	static int n = 0;
	
	static class AddThread implements Runnable{

		@Override
		public void run() {
			for (int i = 0; i < 10000; i++) {
				n++;
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread[] ts = new Thread[10];
		for (int i = 0; i < ts.length; i++) {
			ts[i] = new Thread(new AddThread());
		}
		
		for (int i = 0; i < ts.length; i++) {
			ts[i].start();
		}
		for (int i = 0; i < ts.length; i++) {
			ts[i].join();
		}
		System.out.println(n);
	}
}
