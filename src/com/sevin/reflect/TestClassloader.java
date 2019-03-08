package com.sevin.reflect;

import java.util.ArrayList;
import java.util.List;

/**
 * AppClassLoader:���ص���Դ·����classpath
 * ExtClassLoader:���ص���Դ·����jre/lib/ext/
 * 
 * �������classpath����ͬ��class�ļ�������AppClassLoader��ͬһ��ʵ���������Լ��ص�class��������ͬ�ģ�hashcodeһ�¡�
 * @author Administrator
 *
 */
public class TestClassloader {

	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println(3^2);
		//String classpath= System.getProperty("java.class.path").split(";")[0];f
		
		FileClassLoader f1 = new FileClassLoader("C:\\Users\\Administrator\\Desktop");
		
		FileClassLoader f2 = new FileClassLoader("C:\\Users\\Administrator\\Desktop");
		//Class<?> u1 = f1.findClass("com.sevin.reflect.User");
		//Class<?> u2 = f2.findClass("com.sevin.reflect.User");
		Class<?> u1 = f1.loadClass("com.sevin.reflect.User");
		System.out.println(u1.hashCode() + " " + u1.getSimpleName());
		Class<?> u2 = f2.loadClass("com.sevin.reflect.User");//f1.findClass("com.sevin.reflect.User");
		System.out.println(u2.hashCode() + " " + u2.getSimpleName());
		//System.out.println(Class.forName("com.sevin.reflect.User").hashCode());
		
		
		List<Integer> l = new ArrayList<Integer>();
		l.add(0);l.add(1);l.add(2);l.add(3);l.add(4);l.add(5);l.add(6);l.add(7);l.add(8);l.add(9);l.add(10);l.add(11);l.add(12);
		for (int i = 0; i < l.size()/2; i++) {
			System.out.println(l.subList(i * 2, (i + 1) * 2));
			if (l.size()/2 * 2 < l.size()) {
				System.out.println(l.subList(l.size()/2 * 2, l.size()));
			}
		}
	}
}
