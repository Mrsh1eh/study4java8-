package com.sevin.java8;

public interface Animal {

	void fly();
	
	default void eat(){
		System.out.println("所有动物都会吃");
	}
	
	public static void test(){
		System.out.println("再来试试");
	}
}
