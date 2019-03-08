package com.sevin.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreMutex {
	
	public static void main(String[] args) {
		Semaphore s = new Semaphore(1);
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 20; i++) {
			int count = i;
			Runnable r = new Runnable() {
				
				@Override
				public void run() {
					try {
						s.acquire();
						System.out.println(String.format("Thread: %d, count %d: ", Thread.currentThread().getId(), count));
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						s.release();
						System.out.println("release the mutex");
					}
				}
			};
			service.execute(r);
		}
		service.shutdown();
	}
}
