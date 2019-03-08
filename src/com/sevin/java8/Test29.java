package com.sevin.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test29 {

	private static Map<String, Integer> map = new HashMap<String, Integer>();
	public static void main(String[] args) {
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		map.put("d", 4);
		List<String> l = Arrays.asList("a", "b", "c", "d");
		long start = System.currentTimeMillis();
		l.parallelStream().forEach(s -> {
			try {
				Thread.sleep(5000);
				Test29.test(s);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		System.out.println(System.currentTimeMillis() - start);
		l.parallelStream().forEach(s -> System.out.println(map.get(s)));
	}
	
	private static void test(String s){
		map.put(s, 0);
	}
}
