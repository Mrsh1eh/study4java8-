package com.sevin.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test10 {

	public static void main(String[] args) {
		
/*		Properties p = new Properties();
		p.setProperty("a", "5");
		p.setProperty("b", "true");
		p.setProperty("c", "-3");
		
		System.out.println(readDuration(p, "t"));*/
		System.out.println(8 >>> 1);
		List<Long> list = Arrays.asList(0L, 0L , 0L);
		long count = list.stream().parallel().reduce(0L, Long::sum);
		System.out.println(count);
		
		List<Object> l = list.stream().parallel().flatMap(n -> null).collect(Collectors.toList());
		System.out.println(l == null);
		System.out.println(l.size());
	}
	
	public static int readDuration(Properties p, String name){
		/*return Optional.ofNullable(p.getProperty(name))
			.filter(a -> a.matches("\\d+") && Integer.parseInt(a) > 0).map(Integer::parseInt).orElse(0);*/
		return Optional.ofNullable(p.getProperty(name)).flatMap(Test10::stringToInt).filter(i -> i > 0).orElse(0);
	}
	
	public static Optional<Integer> stringToInt(String s){
		try{
			return Optional.of(Integer.parseInt(s));
		}catch (NumberFormatException e){
			return Optional.empty();
		}
	}
}
