package com.sevin.sync;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDemo {
	
	static AtomicReference<User> ar = new AtomicReference<>();
	public static void main(String[] args) {
		User user = new User(25, "sevin");
		ar.set(user);
		user.setName("–ª ¿∆Ê");
		System.out.println(ar.get());
		while(ar.compareAndSet(user, new User(30, "maggie"))){
			System.out.println(ar.get());
		}
	}

	static class User{
		private int age;
		private String name;
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("User [age=");
			builder.append(age);
			builder.append(", name=");
			builder.append(name);
			builder.append("]");
			return builder.toString();
		}
		public User(int age, String name) {
			super();
			this.age = age;
			this.name = name;
		}
		public User() {
			super();
			// TODO Auto-generated constructor stub
		}
	}
}
