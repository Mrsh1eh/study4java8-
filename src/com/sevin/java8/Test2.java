
package com.sevin.java8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Test2 {

	public static void main(String[] args) throws IOException {
/*		Thread t = new Thread(() -> {System.out.println("ʹ��lambda���ʽ����������");});
		t.start();
		
		System.out.println(processFile((BufferedReader br) -> br.readLine()));
		System.out.println(processFile((BufferedReader br) -> br.readLine() + br.readLine()));
		
		IntPredicate p = (i) -> i % 2 ==0;
		System.out.println(p.test(1000));
		
		Supplier<Boolean> s = () -> true;
		System.out.println(s.get());
		
		Function<String, Integer> f = a -> a.length();
		System.out.println(f.apply("xieshiqi"));
		
		int num = 1000;
		Runnable r = () -> System.out.println(num);
		r.run();
		//num = 20000; lambda���ʽ���õľֲ�����������final����ʵ�������յ�
		
		List<String> str = Arrays.asList("a", "c", "b", "A");
		str.sort(String::compareToIgnoreCase);
		str.forEach(System.out::println);
		
		
		BiPredicate<List<String>, String> contain = List::contains;
		System.out.println(contain.test(str, "c"));
		
		Supplier<Apple> a1 = () -> new Apple(100, "blue");
		System.out.println(a1.get().toString());
		
		Supplier<Apple> a2 = Apple::new;
		System.out.println(a2.get().toString());
		
		Function<Integer, Apple> f1 = Apple::new;
		System.out.println(f1.apply(20).toString());
		
		BiFunction<Integer, String, Apple> a3 = Apple::new;
		System.out.println(a3.apply(30, "green"));*/
		
		
		//����ǩ��(T t) -> boolean
		Predicate<String> predicate = s -> s == null;
		//����ǩ��(T t) -> void
		Consumer<String> consumer = s -> System.out.println(s);
		//����ǩ��(T t) -> R
		Function<String, Integer> function = s -> s.length();
		//����ǩ��() -> T
		Supplier<String> supplier = () -> "I'am sevin";

	}
	
	
	public static String processFile(BufferedReaderProcessor p) throws IOException{
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader("C:\\Users\\Administrator\\Desktop\\xsq.txt"));
			return p.process(br);
		}finally{
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
