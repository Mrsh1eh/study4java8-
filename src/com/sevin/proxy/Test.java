package com.sevin.proxy;

import java.lang.reflect.Proxy;

public class Test {
	public static void main(String[] args) {
		RealSubject rs = new RealSubject();
		ProxySubject ps = new ProxySubject(rs);
		Sub obj = (Sub)Proxy.newProxyInstance(rs.getClass().getClassLoader(), rs.getClass().getInterfaces(), ps);
		obj.say("sevin");
		System.out.println(obj.getClass().getSuperclass());
	}

}
