package com.sevin.sync;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class Test {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException{
/*		Class<Unsafe> c = Unsafe.class;
		Field f = c.getDeclaredField("theUnsafe");
		f.setAccessible(true);
		Unsafe us = (Unsafe) f.get(new Object());
		
		B b = (B) us.allocateInstance(B.class);
		System.out.println(b);
		
		Class<B> cb = B.class;
		Field age = cb.getDeclaredField("age");
		Field name = cb.getDeclaredField("name");
		Field id = cb.getDeclaredField("id");
		id.setAccessible(true);
		us.putInt(b, us.objectFieldOffset(age), 25);
		us.putObject(b, us.objectFieldOffset(name), "sevin");
		System.out.println(id.get(b));
		System.out.println(us.getObject(b, us.objectFieldOffset(name)));

		
		Object clazz = us.staticFieldBase(id);
		us.putObject(clazz, us.staticFieldOffset(id), "123456");
		System.out.println(us.getObject(clazz, us.staticFieldOffset(id)));
		System.out.println(b);
		
		long allocateMemory = us.allocateMemory(1);
		System.out.println(us.getAddress(allocateMemory));
		us.putAddress(allocateMemory, 3435);
		System.out.println(us.getAddress(allocateMemory));*/
	}
	
	public static void test(String... params){
		System.out.println(params[0]);
		if (params.length > 0) {
			System.out.println(params.length + " " + params[0]);
		}else {
			System.out.println("当前没有任务参数");
		}

	}
	
	static class B{
		private int age;
		private String name;
		@SuppressWarnings("unused")
		private static String id = "USER_ID";
		public B() {
			System.out.println("B的构造方法被调用");
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("B [age=");
			builder.append(age);
			builder.append(", name=");
			builder.append(name);
			builder.append("]");
			return builder.toString();
		}
	}
}
