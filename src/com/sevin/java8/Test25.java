package com.sevin.java8;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class Test25 {
	
	public static void main(String[] args) {
		ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
		map.put("xieshiqi", 1);
		map.put("sevin", 2);
		map.put("maggie", 7);
		map.put("ok±Ä", 3);
		Optional<Integer> of = Optional.of(map.reduceValues(1, Integer::max));
		System.out.println(of.get());
		
		long count = map.mappingCount();
		System.out.println(count);
		int size = map.size();
		System.out.println(size);
		
		boolean logicalXor = Boolean.logicalXor(false, true);
		System.out.println(logicalXor);
	}

}
