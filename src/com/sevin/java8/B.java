package com.sevin.java8;

import java.util.Arrays;

@Author(name = "Raoul")
@Author(name = "Mario")
@Author(name = "Alan")
public class B{
	public static void main(String[] args) {
		Author[] authors = B.class.getAnnotationsByType(Author.class);
		Arrays.asList(authors).forEach(a -> System.out.println(a.name()));
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		}).start();
	}
}