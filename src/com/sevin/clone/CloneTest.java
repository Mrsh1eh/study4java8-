package com.sevin.clone;

public class CloneTest {
	public static void main(String[] args) throws CloneNotSupportedException {
		CloneObject co = new CloneObject();
		System.out.println(co);
		CloneObject clone = co.clone();
		System.out.println(String.format("co:%d, clone:%d", co.hashCode(), clone.hashCode()));
	
		co.setName("sevin");
		co.setAge(24);
		System.out.println(co);
		System.out.println(clone);
	}
}
