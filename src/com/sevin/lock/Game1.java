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
			System.out.println(Thread.currentThread().getName() + ",���ۿ�Ѽ������" + count);
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
					System.out.println("�����ߣ�" + Thread.currentThread().getName() + "�����ڵȴ���Ѽ��");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("");
			flag = false;
			pcon.signal();
			System.out.println("�����ߣ�" + Thread.currentThread().getName() + "����ʣ��Ѽ������" + --count);
		}finally{
			lock.unlock();
		}
	}

	public int getCount() {
		return count;
	}

}
