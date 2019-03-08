package com.sevin.java8;

public interface C extends A{

	default void hello(){
		System.out.println("I'am C");
	}
}
