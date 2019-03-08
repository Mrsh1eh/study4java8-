package com.sevin.java8;

import java.util.Comparator;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import static java.util.stream.Collectors.*;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.sevin.java8.Dish.Type;

public class Test7 {

	public static void main(String[] args) {
		
		Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]}).limit(20)
			.forEach(n -> System.out.println(n[0] + " " + n[1]));
		
		Dish.menu.stream().max(Comparator.comparing(Dish::getCalories)).ifPresent(System.out::println);
		
		Dish.menu.stream().collect(maxBy(Comparator.comparing(Dish::getCalories))).ifPresent(System.out::println);
		
		//热量总和
		int sum = Dish.menu.stream().collect(summingInt(Dish::getCalories));
		System.out.println(sum);
		
		//热量平均值
		double avg = Dish.menu.stream().collect(averagingInt(Dish::getCalories));
		System.out.println(avg);
		
		IntSummaryStatistics collect = Dish.menu.stream().collect(summarizingInt(Dish::getCalories));
		System.out.println(collect);
		
		String names = Dish.menu.stream().map(Dish::getName).collect(joining(", "));
		System.out.println(names);
		
		Integer n = Dish.menu.stream().collect(reducing(0,  Dish::getCalories, Integer::sum));
		System.out.println(n);
		
		int s = Dish.menu.stream().mapToInt(Dish::getCalories).sum();
		System.out.println(s);
		
		//分组
		Map<Type, List<Dish>> m1 = Dish.menu.stream().collect(groupingBy(Dish::getType));
		System.out.println(m1);
		
		//自定义分类函数lambda进行分组
		Map<CaloricLevel, List<Dish>> m2 = Dish.menu.stream().collect(groupingBy(d -> {
			if(d.getCalories() <= 400) return CaloricLevel.DIEF;
			else if(d.getCalories() <= 700) return CaloricLevel.NORMAL;
			else return CaloricLevel.FAT;
		}));
		System.out.println(m2);
		
		//二级分组
		Map<Type, Map<CaloricLevel, List<Dish>>> m3 = Dish.menu.stream().collect(groupingBy(Dish::getType, groupingBy(d -> {
			if(d.getCalories() <= 400) return CaloricLevel.DIEF;
			else if(d.getCalories() <= 700) return CaloricLevel.NORMAL;
			else return CaloricLevel.FAT;
		}))); 
		System.out.println(m3);
		
		Map<Type, Long> m4 = Dish.menu.stream().collect(groupingBy(Dish::getType, counting()));
		System.out.println(m4);
		
		//菜的类型分类中热量最高的菜肴
		Map<Type, Optional<Dish>> m5 = Dish.menu.stream().collect(groupingBy(Dish::getType, maxBy(Comparator.comparing(Dish::getCalories))));
		System.out.println(m5);
		
		Map<Type, Dish> m6 = Dish.menu.stream().collect(groupingBy(Dish::getType, 
				collectingAndThen(maxBy(Comparator.comparing(Dish::getCalories)), Optional::get)));
		System.out.println(m6);
		
		Map<Type, Integer> m7 = Dish.menu.stream().collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));
		System.out.println(m7);
		
		Map<Type, Set<CaloricLevel>> m8 = Dish.menu.stream().collect(groupingBy(Dish::getType, mapping(d -> {
			if(d.getCalories() <= 400) return CaloricLevel.DIEF;
			else if(d.getCalories() <= 700) return CaloricLevel.NORMAL;
			else return CaloricLevel.FAT;
		}, toCollection(HashSet::new))));
		System.out.println(m8);
		
		//分区（分组的一种特殊情况，分类函数是谓词）
		Map<Boolean, List<Dish>> m9 = Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian));
		System.out.println(m9);
		
		Map<Boolean, Map<Type, List<Dish>>> m10 = Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));
		System.out.println(m10);
		
		Map<Boolean, Optional<Dish>> m11 = Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian, maxBy(Comparator.comparing(Dish::getCalories))));
		System.out.println(m11);
		
		Map<Boolean, Dish> m12 = Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian, collectingAndThen(maxBy(Comparator.comparing(Dish::getCalories)), Optional::get)));
		System.out.println(m12);
		
		Map<Boolean, Map<Boolean, List<Dish>>> m13 = Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian, partitioningBy(d -> d.getCalories() > 500)));
		System.out.println(m13);
		
		System.out.println(partitionPrimes(20));
	}
	
	public static boolean isPrime(int candidate){
		int sqrt = (int) Math.sqrt(candidate);
		return IntStream.rangeClosed(2, sqrt).noneMatch(n -> candidate % n == 0);
	}

	public static Map<Boolean, List<Integer>> partitionPrimes(int i){
		return IntStream.rangeClosed(2, i).boxed().collect(partitioningBy(x -> isPrime(x)));
	}
	
	
	public enum CaloricLevel {DIEF, NORMAL, FAT}
}
