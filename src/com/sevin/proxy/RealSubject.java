package com.sevin.proxy;

public class RealSubject implements Sub{
	
	public void say(String name){
		System.out.println("������ʵ����, " + name);
	}

}

interface Sub{void say(String name);}