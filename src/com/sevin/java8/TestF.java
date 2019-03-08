package com.sevin.java8;

public class TestF {

	public static void main(String[] args) {
	    SonClass son = new SonClass();
	    FatherClass father = new FatherClass();
	    father.setName("father");
	    father.setAge(50);
	    son.setName("son");
	    son.setAge(18);
	    son.setFair("ÓÐÍ··¢");
	    System.out.println(son.toString());
	    System.out.println(father.toString());
	}
}
