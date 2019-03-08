package com.sevin.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TooManyListenersException;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test1 {
	
	public static void main(String[] args) {
		
		List<Apple> apples = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"),
                new Apple(120, "bule"));
		
		List<Apple> greenApples  = filterApples(apples, Test1::isGreenApple);
		System.out.println(greenApples);
		
		List<Apple> heavyApples  = filterApples(apples, Test1::isHeavyApple);
		System.out.println(heavyApples);
		
		List<Apple> greenApples2 = filterApples(apples, a -> "green".equals(a.getColor()));
		 System.out.println(greenApples2);
		 
		 List<Apple> heavyApples2 = filterApples(apples, a -> a.getWeight() > 150);
		 System.out.println(heavyApples2);
		 
		 List<Apple> weirdApples = filterApples(apples, a -> "brown".equals(a.getColor()) || a.getWeight() < 80);
		 System.out.println(weirdApples);
		 
		 //根据重量排序,降序;如果质量一样，按照颜色排序。
		 apples.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));
		 apples.forEach(System.out::println);
		 
		 Predicate<Apple> p = a -> a.getColor().equals("red");
		 Predicate<Apple> negate = p.negate();
		 apples.forEach(a -> System.out.println(negate.test(a)));
		 
		 Predicate<Apple> and = p.and(a -> a.getWeight() < 150);
		 apples.forEach(a -> System.out.println(and.test(a)));
		 
		 Predicate<Apple> or = p.and(a -> a.getWeight() < 150).or(a -> "green".equals(a.getColor()));
		 apples.forEach(a -> System.out.println(or.test(a)));
	}
	
    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }
	
    public static List<Apple> filterHeavyApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }
    
    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor()); 
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }
    
    public static List<Apple> filterApples(List<Apple> apples, Predicate<Apple> p){
    	List<Apple> result = new ArrayList<Apple>();
    	for (Apple apple : apples) {
			if (p.test(apple)) {
				result.add(apple);
			}
		}
    	return result;
    }
    
	static class Apple{
		private Integer weight = 0;
		private String color = null;
		public Integer getWeight() {
			return weight;
		}
		public void setWeight(Integer weight) {
			this.weight = weight;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		@Override
		public String toString() {
			return "Apple [weight=" + weight + ", color=" + color + "]";
		}
		public Apple(int weight, String color) {
			super();
			this.weight = weight;
			this.color = color;
		}
		public Apple() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Apple(Integer weight) {
			super();
			this.weight = weight;
		}
	}

}
