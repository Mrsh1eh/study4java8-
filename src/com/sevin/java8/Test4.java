package com.sevin.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test4 {
	
	public static void main(String[] args) {
		List<String> names = Dish.menu.stream()
			.filter(d -> {System.out.println("filter : " + d.getName());
										return d.getCalories() > 300;})
			//.sorted(Comparator.comparing(Dish::getCalories))
			.map(d -> {System.out.println("mapping : " + d.getName());
						return d.getName();})
			.limit(3)
			.collect(Collectors.toList());
		
		System.out.println(names);
		
		Dish.menu.stream().map(d -> 1).reduce(Integer::sum).ifPresent(System.out::println);
		
		List<Integer> num = Arrays.asList(1, 2, 4, 3, 5, 6, 4, 2, 5, 8);
		num.stream()
			.filter(i -> i % 2 == 0)
			.distinct()
			.skip(2)
			.limit(3)
			.forEach(System.out::println);
		
		System.out.println(num.stream().reduce(0, Integer::sum));
		num.stream().reduce(Integer::sum).ifPresent(System.out::println);
		num.stream().reduce(Integer::max).ifPresent(System.out::println);
		num.stream().reduce(Integer::min).ifPresent(System.out::println);
		
		List<String> words = Arrays.asList("Hello", "World");
		words.stream()
					.map(w -> w.split(""))
					.flatMap(Arrays::stream)
					.distinct()
					.forEach(System.out::println);
		
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
		nums.stream()	
					.map(n -> n * n)
					.forEach(System.out::println);
		
		List<Integer> n1 = Arrays.asList(1, 2, 3);
		List<Integer> n2 = Arrays.asList(3, 4);
		
		//n1.stream().flatMap(n -> n2.stream().map(a -> new Integer []{n, a})).forEach(k -> System.out.println(k[0] + " " + k[1]));
		
		System.out.println("==============================");
		
/*		n1.stream().flatMap(n -> n2.stream().filter(s -> {
			System.out.println("s : " + s + " , n : " + n);
			return (n + s)%3 ==0;})
											.map(a -> {
												System.out.println("a : " + a + " , n : " + n);
												return new Integer []{n, a};})).forEach(k -> System.out.println(k[0] + " " + k[1]));*/
											
			
		if (Dish.menu.stream().anyMatch(Dish::isVegetarian)) {
			System.out.println("The menu is (somewhat) vegetarian frindly!!");
		}
		
		System.out.println(Dish.menu.stream().allMatch(n -> n.getCalories() < 1000));
		System.out.println(Dish.menu.stream().noneMatch(n -> n.getCalories() >= 1000));
		System.out.println(Dish.menu.stream().findFirst().get());
		
		Optional<Dish> dish = Dish.menu.stream().filter(n -> n.getCalories() >= 1000).findAny();
		System.out.println(dish.isPresent());
		dish.ifPresent(System.out::println);
		System.out.println(dish.orElse(new Dish("abc", true, 350, Dish.Type.OTHER)));
		//System.out.println(dish.get().getName());
		
		System.out.println(Dish.menu.stream().mapToInt(Dish::getCalories).max());
		
	}

}
