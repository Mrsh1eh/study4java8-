package com.sevin.java8;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test6 {
	
	public static void main(String[] args) {
		
		System.out.println(IntStream.range(1, 100).filter(i -> i % 2 == 0).count());
		System.out.println(IntStream.rangeClosed(1, 100).filter(i -> i % 2 == 0).count());
		
/*		IntStream.rangeClosed(1, 100).boxed()
									 .flatMap(a -> 
										 IntStream.rangeClosed(a, 100)
										 		  .mapToObj(b -> new double[]{a, b, Math.sqrt(a*a + b*b)}))
									 .filter(t -> t[2] % 1 == 0)
									 .forEach(c -> System.out.println(c[0] + " " + c[1] + " " + c[2]));*/
		
		Stream<String> of = Stream.of("Java 8 ", "lambdas ", "In ", "Action ");
		of.map(String::toUpperCase).forEach(System.out::println);
		
		int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println(Arrays.stream(num).sum());
		
		try {
			long count = Files.lines(Paths.get("C:\\Users\\Administrator\\Desktop\\xsq.txt"), Charset.defaultCharset())
			.map(s -> s.split(""))
			.flatMap(Arrays::stream)		
			.distinct()
			.count();
			System.out.println(count);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//无限流，一般使用limit来限制
		//Stream.iterate(0,  n -> n + 2).forEach(System.out::println); 
		Stream.iterate(0,  n -> n + 2).limit(4).forEach(System.out::println); 							 
	}

}
