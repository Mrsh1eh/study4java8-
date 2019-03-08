package com.sevin.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		Semaphore sp = new Semaphore(5);
		System.out.println(sp.availablePermits());
		for (int i = 0; i < 20; i++) {
			final int count = i;
			Runnable r = new Runnable() {
				@Override
				public void run() {
					try {
						sp.acquire();
						System.out.println(String.format("µ±Ç°ÐòÁÐºÅ£º%d", count));
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						sp.release();
					}
				}
			};
			service.execute(r);
		}
		service.shutdown();
		System.out.println(sp.getQueueLength());
		System.out.println(sp.isFair());
	}
}
