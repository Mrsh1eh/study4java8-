package com.sevin.java8;

public class SonClass extends FatherClass {
	private String fair;

    private String name;

    private int age;

    public SonClass(){

    }

    public String getFair() {
        return fair;
    }

    public void setFair(String fair) {
        this.fair = fair;
        System.out.println("setFair : " + this.toString());
    }


    @Override
    public String toString() {
        return "SonClass{" +
                "fair='" + this.fair + '\'' +
                ", name='" + this.name + '\'' +
                ", age=" + this.age +
                '}';
    }
}
