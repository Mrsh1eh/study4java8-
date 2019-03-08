package com.sevin.sync;

import com.sevin.annotation.QuicklyWay;

public class SyncTest implements Runnable{
	
	static int i;

	@Override
	public void run() {
		for (int i = 0; i < 100000; i++) {
			increase();
		}
	}
	
	public synchronized void increase(){
		i++;
	}

	public static void main(String[] args) throws InterruptedException {
		//SyncTest st = new SyncTest();
/*		Thread t1 = new Thread(new SyncTest());
		Thread t2 = new Thread(new SyncTest());
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(i);*/
		System.out.println(0x00000001);
	}
	
	public static class B{
		public Object clone() throws CloneNotSupportedException{
			return super.clone();
		}
	}
	
}
