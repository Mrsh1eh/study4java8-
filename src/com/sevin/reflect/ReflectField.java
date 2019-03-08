package com.sevin.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectField {

	public static void main(String[] args) throws Exception {
		
		Class<?> clazz = Class.forName("com.sevin.reflect.Student");
		
/*		Constructor<?>[] c1 = clazz.getDeclaredConstructors();
		for (int i = 0; i < c1.length; i++) {
			System.out.println(c1[i]);
		}
		
		Field f1 = clazz.getField("courses");
		System.out.println(f1.toGenericString());
		System.out.println(f1.toString());
		
		Field f2 = clazz.getField("name");
		System.out.println(f2.toGenericString());
		System.out.println(f2.toString());
		
		Field f3 = clazz.getDeclaredField("score");
		System.out.println(f3.toGenericString());
		System.out.println(f3.toString());
		
		Field f4 = clazz.getDeclaredField("grade");
		System.out.println(f4.toGenericString());
		System.out.println(f4.toString());
		
		Field[] fs1 = clazz.getFields();
		for (int i = 0; i < fs1.length; i++) {
			System.out.println(fs1[i].toString());
		}
		
		Field[] fs2 = clazz.getDeclaredFields();
		for (int i = 0; i < fs2.length; i++) {
			System.out.println(fs2[i].toString());
		}
		
		
		Student s = (Student) clazz.newInstance();
		System.out.println(f3.getType() + "      " + f3.getName() + "    " + f3.getDeclaringClass());
		f3.setAccessible(true);
		f3.setDouble(s, 1.22);
		f4.setInt(s, 2);
		
		System.out.println(s.toString() + "=========" + s.getGrade());*/
		
		Student s2 = (Student) clazz.newInstance();
		System.out.println(s2.toString());
		Method m1 = clazz.getDeclaredMethod("setScore", double.class);
		System.out.println(m1.getReturnType() + "   " + m1.getName() + "    " + m1.isVarArgs() + "  " + m1.toGenericString());
		Object invoke = m1.invoke(s2, 1.44);
		System.out.println(invoke);

		Method m2 = clazz.getDeclaredMethod("getScore");
		System.out.println(m2.getReturnType() + "   " + m1.getName() + "    " + m1.isVarArgs() + "  " + m2.toString());
		Object invoke2 = m2.invoke(s2);
		System.out.println(invoke2);
		
	}
}
