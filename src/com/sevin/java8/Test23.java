package com.sevin.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Test23 {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		System.out.println(map.get("xieshiqi"));
		System.out.println(map.getOrDefault("xieshiqi", 22));
		
		map.put("sevin", 4);
		int size = map.size();
		System.out.println(size);
		System.out.println(map.computeIfAbsent("sevin", s -> s.length()));
		
		List<String> l = new ArrayList<>();
		l.add("xieshiqi");
		l.add("sevin");
		l.add("maggie");
		l.add("chaochao");
		boolean removeIf = l.removeIf(a -> "chaochao".equals(a));
		l.forEach(System.out::println);
		
		List<Integer> list = Arrays.asList(5,3,8,2,7,6,4);
		list.replaceAll(i -> i + 1);
		list.forEach(System.out::println);
		//list.sort(Comparator.comparingInt(Integer::intValue));
		System.out.println("======================================");
		list.sort(Comparator.naturalOrder());
		list.forEach(System.out::println);
		
		AtomicInteger a = new AtomicInteger(9);
		System.out.println(a.accumulateAndGet(10, Integer::max));
		System.out.println(a.get());
	}
}
