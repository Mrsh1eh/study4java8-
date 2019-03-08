package com.sevin.reflect;

import java.lang.reflect.Array;

public class ReflectArray {

	public static void main(String[] args) throws NegativeArraySizeException, ClassNotFoundException {
/*		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Class<? extends int[]> class1 = array.getClass();
		System.out.println(class1.toString());
		Class<?> c1 = array.getClass().getComponentType();
		System.out.println(c1.toString());
		
		Object newInstance = Array.newInstance(c1, 15);
		int l = Array.getLength(array);
		System.arraycopy(array, 0, newInstance, 0, l);
		for (int i : (int[])newInstance) {
			System.out.println(i);
		}*/
		
		Object s = Array.newInstance(Class.forName("java.lang.String"), 10);
		Array.set(s, 6, "hello world!");
		String a = (String) Array.get(s, 6);
		System.out.println(a);
	}
	
	public <T extends Comparable<T>> void min(T[] a){
		a.getClass().getComponentType();
		
	}
}
