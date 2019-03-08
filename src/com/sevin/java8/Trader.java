package com.sevin.java8;

public class Trader {

	private final String name;
	
	private final String city;

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	public Trader(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Trader [name=");
		builder.append(name);
		builder.append(", city=");
		builder.append(city);
		builder.append("]");
		return builder.toString();
	}
}
