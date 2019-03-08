package com.sevin.sync;

import java.util.concurrent.TimeUnit;

public class TestA {

	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().getName());
		Thread t = new Thread() {
			
			@Override
			public void run() {
				while(true){
					System.out.println("目前还没有被中断, " + Thread.currentThread().getName());
					if (this.isInterrupted()) {
						//Thread.interrupted()会清除当前中断状态
						System.out.println("已经被中断， " + Thread.currentThread().getName());
					}
				}
				
			}
		};
		
		t.start();
		//TimeUnit.SECONDS.sleep(2);
		t.interrupt();
		

	}
}
