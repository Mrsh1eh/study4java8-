package com.sevin.java8;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

public class Test24 {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(10);
		LongAdder adder = new LongAdder();
		for (int i = 0; i < 100; i++) {
			service.submit(() -> adder.add(10));
		}

		Thread.sleep(5000);
		
		System.out.println(adder.sum());
	}
	
	public static int n = 0;
}
