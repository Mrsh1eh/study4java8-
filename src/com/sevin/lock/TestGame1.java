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
		}, "一号烤鸭师傅");
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				while(true){
					g.produce();
				}
			}
		}, "二号烤鸭师傅");
		
		Thread t3 = new Thread(new Runnable() {
			public void run() {
				while(true){
					g.consumer();
				}
			}
		}, "第一位顾客");
		
		Thread t4 = new Thread(new Runnable() {
			public void run() {
				while(true){
					g.consumer();
				}
			}
		}, "第二位顾客");
		t1.start();
		t2.start();t3.start();t4.start();
		t1.join();
		t2.join();t3.join();t4.join();
		System.out.println(g.getCount());
	}

}
