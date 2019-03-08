package com.sevin.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReenerLock implements Runnable {
	
	private static ReentrantLock lock = new ReentrantLock(true);
	
	private static int j = 0;
	

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			lock.lock();
			lock.lock();
			try{
				j++;
				//System.out.println(j);
			}finally{
				//lock.unlock();
				lock.unlock();
			}
		}

	}
	public static void main(String[] args) throws InterruptedException {
		ReenerLock rl = new ReenerLock();
		Thread t1 = new Thread(rl);
		Thread t2 = new Thread(rl);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(lock.getHoldCount());
		//System.out.println(j);
	}

}
