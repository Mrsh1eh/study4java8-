package com.sevin.clone;

public class CloneObject implements Cloneable {
	
	private String name = "xieshiqi";
	
	private int age = 25;
	
	private Long tel = 18357877571L;
	
	public static String nikeName = "С·";
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Long getTel() {
		return tel;
	}

	public void setTel(Long tel) {
		this.tel = tel;
	}

	public CloneObject clone() throws CloneNotSupportedException{
		CloneObject cobj = (CloneObject) super.clone();
		return cobj;
	}

	@Override
	public String toString() {
		return "CloneObject [name=" + name + ", age=" + age + ", tel=" + tel + "]";
	}
}
