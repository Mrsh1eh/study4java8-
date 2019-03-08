package com.sevin.sync;

import java.util.concurrent.TimeUnit;

import sun.reflect.Reflection;

public class TestB {

	 public static void main(String[] args) throws InterruptedException {
		 	Class<?> c = Reflection.getCallerClass();
		 	System.out.println(c.getName());
	        Thread t1 = new Thread() {
	            @Override
	            public void run() {
	                //while��try�У�ͨ���쳣�жϾͿ����˳�runѭ��
	                try {
	                    while (true) {
	                        //��ǰ�̴߳�������״̬���쳣���벶׽�����޷������׳�
	                        TimeUnit.SECONDS.sleep(2);
	                    }
	                } catch (InterruptedException e) {
	                    System.out.println("Interruted When Sleep");
	                    boolean interrupt = this.isInterrupted();
	                    //�ж�״̬����λ
	                    System.out.println("interrupt:"+interrupt);
	                }
	            }
	        };
	        t1.start();
	        TimeUnit.SECONDS.sleep(2);
	        //�жϴ�������״̬���߳�
	        t1.interrupt();

	        /**
	         * ������:
	           Interruted When Sleep
	           interrupt:false
	         */
	    }
}
