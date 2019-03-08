package com.sevin.reflect;

import java.lang.reflect.Constructor;

public class ReflectTest {
/*
	public static void main(String[] args) throws Exception {
		Class<?> clazz = Class.forName("com.sevin.reflect.User");
		User user = (User) clazz.newInstance();
		user.setAge(24);
		user.setName("sevin");
		user.setPhone(18357877571L);
		System.out.println(user);
		
		Constructor<?>[] c1 = clazz.getConstructors();
		for (Constructor<?> c : c1) {
			System.out.println(c);
		}
		
		Constructor<?>[] c3 = clazz.getDeclaredConstructors();
		for (Constructor<?> c : c3) {
			System.out.println(c.toGenericString());
			System.out.println(c.toString());
			Class<?>[] parameterTypes = c.getParameterTypes();
			for (int i = 0; i < parameterTypes.length; i++) {
				System.out.println(parameterTypes[i]);
			}
		}
		
		Constructor<?> c4 = clazz.getDeclaredConstructor(String.class);
		System.out.println(c4.isAccessible());
		User u1 = (User) c4.newInstance("sevin");
		System.out.println(u1);
		
		c4 = clazz.getDeclaredConstructor(String.class, int.class);
		System.out.println(c4.isAccessible());
		User u2 = (User) c4.newInstance("sevin", 24);
		System.out.println(u2);
		
		c4 = clazz.getDeclaredConstructor(String.class, int.class, long.class);
		System.out.println(c4.isAccessible());
		c4.setAccessible(true);
		User u3 = (User) c4.newInstance("sevin", 24, 18357877571L);
		System.out.println(c4.isAccessible());
		System.out.println(u3);
	}*/
}

