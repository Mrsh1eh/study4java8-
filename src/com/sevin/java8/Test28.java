package com.sevin.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test28 {

	public static void main(String[] args) {
		//ˢѡ������7�����ֲ����н������ƴ���ַ���
		List<Integer> nums = Arrays.asList(2, 5, 10, 6, 9, 11, 1, 13, 7);
		
		//��һ����ˢѡ
		List<Integer> newNums = new ArrayList<>();
		for (Integer n : nums) {
			if(n > 7){
				newNums.add(n);
			}
		}
		//�ڶ���������
		newNums.sort(new Comparator<Integer>() {//�������˽ӿ�List��Ĭ�Ϸ���sort()
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		//��������ƴ���ַ���
		List<String> strs = new ArrayList<>();
		for (Integer n : newNums) {
			strs.add("the number is : " + n);
		}

		List<String> l = nums.stream().filter(n -> n > 7).sorted(Comparator.comparing(Integer::intValue)).map(i -> "the number is : " + i)
				.collect(Collectors.toList());
		
		l.forEach(System.out::println);
	}
}
