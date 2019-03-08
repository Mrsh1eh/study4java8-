package com.sevin.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test28 {

	public static void main(String[] args) {
		//刷选出大于7的数字并进行降序，最后拼接字符串
		List<Integer> nums = Arrays.asList(2, 5, 10, 6, 9, 11, 1, 13, 7);
		
		//第一步：刷选
		List<Integer> newNums = new ArrayList<>();
		for (Integer n : nums) {
			if(n > 7){
				newNums.add(n);
			}
		}
		//第二步：降序
		newNums.sort(new Comparator<Integer>() {//这里用了接口List的默认方法sort()
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		//第三步：拼接字符串
		List<String> strs = new ArrayList<>();
		for (Integer n : newNums) {
			strs.add("the number is : " + n);
		}

		List<String> l = nums.stream().filter(n -> n > 7).sorted(Comparator.comparing(Integer::intValue)).map(i -> "the number is : " + i)
				.collect(Collectors.toList());
		
		l.forEach(System.out::println);
	}
}
