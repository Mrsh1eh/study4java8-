package com.sevin.sync;

import java.util.concurrent.TimeUnit;

public class TestA {

	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().getName());
		Thread t = new Thread() {
			
			@Override
			public void run() {
				while(true){
					System.out.println("Ŀǰ��û�б��ж�, " + Thread.currentThread().getName());
					if (this.isInterrupted()) {
						//Thread.interrupted()�������ǰ�ж�״̬
						System.out.println("�Ѿ����жϣ� " + Thread.currentThread().getName());
					}
				}
				
			}
		};
		
		t.start();
		//TimeUnit.SECONDS.sleep(2);
		t.interrupt();
		

	}
}
