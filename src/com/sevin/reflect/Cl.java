package com.sevin.reflect;

import java.io.File;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Cl {

	public static void main(String[] args) throws ClassNotFoundException {
/*		Properties ps = System.getProperties();
		for (Entry<Object, Object> entry : ps.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}*/
		
/*		System.out.println(System.getProperty("sun.boot.class.path"));
		String s = System.getProperty("java.ext.dirs");*/
		//System.out.println(s);
		
/*		Scanner scanner = new Scanner(s);
		scanner.useDelimiter(";");
		while(scanner.hasNext()){
			System.out.println(scanner.next());
		}
		
		String s1 = System.getProperty("java.class.path");
		System.out.println(s1);
		
		Scanner scanner1 = new Scanner(s1);
		scanner1.useDelimiter(";");
		while(scanner1.hasNext()){
			System.out.println(scanner1.next());
		}
	
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		System.out.println(cl);*/
		
		IntegerForm a = new IntegerForm();
/*		Cl c = new Cl();
		System.out.println(c.getClass().getClassLoader());
		Class<?> loadClass = c.getClass().getClassLoader().loadClass("java.lang.IntegerForm");
		System.out.println(loadClass);*/
	}
}
