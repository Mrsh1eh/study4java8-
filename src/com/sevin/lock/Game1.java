package com.sevin.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Game1 {
	
	private ReentrantLock lock = new ReentrantLock();
	
	private boolean flag = false;
	
	private int count = 0;
	
	private Condition pcon = lock.newCondition();
	
	private Condition ccon = lock.newCondition();
	
	protected void produce(){
		lock.lock();
		try{
			while(flag){
				try {
					pcon.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}			
			flag = true;
			count++;
			System.out.println(Thread.currentThread().getName() + ",在售烤鸭数量：" + count);
			ccon.signal();
		}finally{
			lock.unlock();
		}
	}
	
	protected void consumer(){
		lock.lock();
		try{
			while (!flag) {
				try {
					ccon.await();
					System.out.println("消费者：" + Thread.currentThread().getName() + "，处于等待烤鸭！");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("");
			flag = false;
			pcon.signal();
			System.out.println("消费者：" + Thread.currentThread().getName() + "，还剩烤鸭数量：" + --count);
		}finally{
			lock.unlock();
		}
	}

	public int getCount() {
		return count;
	}

}
