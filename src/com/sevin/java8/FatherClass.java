package com.sevin.java8;

public class FatherClass {
	private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("setName : " + this.toString());
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        System.out.println("setAge : " + this.toString());
    }

	@Override
    public String toString() {
        return "FatherClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
