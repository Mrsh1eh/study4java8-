package com.sevin.lock;

public class TestGame1 {
	public static void main(String[] args) throws InterruptedException {
		
		Game1 g = new Game1();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				while(true){
					g.produce();
				}
			}
		}, "һ�ſ�Ѽʦ��");
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				while(true){
					g.produce();
				}
			}
		}, "���ſ�Ѽʦ��");
		
		Thread t3 = new Thread(new Runnable() {
			public void run() {
				while(true){
					g.consumer();
				}
			}
		}, "��һλ�˿�");
		
		Thread t4 = new Thread(new Runnable() {
			public void run() {
				while(true){
					g.consumer();
				}
			}
		}, "�ڶ�λ�˿�");
		t1.start();
		t2.start();t3.start();t4.start();
		t1.join();
		t2.join();t3.join();t4.join();
		System.out.println(g.getCount());
	}

}
