package com.sevin.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxySubject implements InvocationHandler{
	
	private RealSubject rs = null;

	public ProxySubject(RealSubject rs) {
		super();
		this.rs = rs;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		method.invoke(rs, args);
		return null;
	}

}
