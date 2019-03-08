package com.sevin.proxy;

public class RealSubject implements Sub{
	
	public void say(String name){
		System.out.println("我是真实的类, " + name);
	}

}

interface Sub{void say(String name);}