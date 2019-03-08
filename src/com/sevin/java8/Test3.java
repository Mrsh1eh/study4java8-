package com.sevin.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Test3 {
	
	public static void main(String[] args) {
		//Function andThen
		Function<Integer, Integer> f1 = x -> x + 1;
		Function<Integer, Integer> f2 = x -> x * 2;
		Function<Integer, Integer> andThen = f1.andThen(f2);
		
		System.out.println(andThen.apply(2));
		
		Function<Integer, Integer> compose = f1.compose(f2);
		System.out.println(compose.apply(2));
		
		List<String> list = Arrays.asList("Java8", "In", "action");
		Stream<String> stream = list.stream();
		stream.forEach(System.out::println);
		//stream.forEach(System.out::printf);流只能被遍历一次
		
		list.stream().forEach(System.out::println);//集合能被多次遍历
	}

}
