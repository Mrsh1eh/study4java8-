package com.sevin.java8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test30 {

	private int i;
	public void test(){
		synchronized (this) {
			++i;
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		Test30 t = new Test30();
		ExecutorService service = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10000; i++) {
			service.submit(new Runnable() {
				public void run() {
					t.test();
				}
			});
		}
		service.shutdown();
		
		System.out.println(t.i);
	}
	
}
