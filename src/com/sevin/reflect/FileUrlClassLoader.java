package com.sevin.reflect;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

public class FileUrlClassLoader extends URLClassLoader {

	public FileUrlClassLoader(URL[] urls) {
		super(urls);
	}

	public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
		System.out.println(System.getProperty("jdbc.drivers"));
		File f = new File("C:\\Users\\Administrator\\Desktop");

		FileUrlClassLoader c = new FileUrlClassLoader(new URL[] { f.toURI().toURL() });
		Class<?> u = c.loadClass("com.sevin.reflect.User");
		System.out.println(u.hashCode());
		Object obj = u.newInstance();
		Field name = u.getDeclaredField("phone");
		Arrays.stream(u.getDeclaredFields()).forEach(System.out::println);
		name.setAccessible(true);
		name.setLong(obj, 18357877571L);
		
		Method getName = u.getDeclaredMethod("getPhone");
		Object value = getName.invoke(obj);
		System.out.println(value);
	}
}
