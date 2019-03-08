package com.sevin.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.DoubleUnaryOperator;

public class Test21 {
	public static void main(String[] args) {
		
		doint("xie", "shi");
		DoubleUnaryOperator converter = converter(9.0/5, 32);
		System.out.println(converter.applyAsDouble(1000));
		
		List<String> l = null;
		for (String string : l) {
			System.out.println(string);
		}
	}
	
	public static DoubleUnaryOperator converter(double f , double b){
		return (double x) -> x * f + b;
	}
	
	public static void doint(String... args){
		System.out.println(args);
	}
}
