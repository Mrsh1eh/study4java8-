package com.sevin.java8;

public interface Animal {

	void fly();
	
	default void eat(){
		System.out.println("���ж��ﶼ���");
	}
	
	public static void test(){
		System.out.println("��������");
	}
}
