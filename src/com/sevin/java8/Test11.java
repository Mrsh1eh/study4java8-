package com.sevin.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test11 {

	public static void main(String[] args) {
		
		CompletableFuture<Integer> a = CompletableFuture.supplyAsync(() -> 100);
		CompletableFuture<Void> ta = a.thenAccept(System.out::println);
		
		try {
			ta.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
/*		System.out.println("xieshiqi".charAt(0) * "xieshiqi".charAt(1));
		CompletableFuture<Integer> f = CompletableFuture.supplyAsync(() -> {
			int i = 1/0;
			return 100;
		});
		
		try {3
			System.out.println(f.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		System.out.println(f.join());*/
		
		CompletableFuture<String> compose = CompletableFuture.supplyAsync(() -> 100)
				.thenCompose(i -> CompletableFuture.supplyAsync(() -> String.valueOf(i + 100)));

		System.out.println(compose.join());
		
		List<String> list = Arrays.asList("maggie", "sevin", "steven", "paul", "daivd");
		long start = System.nanoTime();
		//顺序同步执行
/*		List<String> results = list.stream().map(s -> {
			Util.delay();
			return "hello, " + s;}).map(s -> {
				Util.delay();
				return s + ". I'm Java8";
			}).collect(Collectors.toList());
		System.out.println((System.nanoTime() - start) / 1_000_000);
		results.forEach(System.out::printf);*/
		
		List<CompletableFuture<String>> collect = list.stream().map(s -> CompletableFuture.supplyAsync(() -> {
			Util.delay();
			return "hello, " + s;})).map(f -> f.thenCompose(s -> CompletableFuture.supplyAsync(() ->{
				Util.delay();
				return s + ". I'm Java8";
			}))).collect(Collectors.toList());
		
		List<String> collect2 = collect.stream().map(CompletableFuture::join).collect(Collectors.toList());
		System.out.println((System.nanoTime() - start) / 1_000_000);
		collect2.forEach(System.out::printf);
		
		List<CompletableFuture<String>> collect3 = list.stream().map(s -> CompletableFuture.supplyAsync(() -> {
			Util.delay();
			return "hello, " + s;
		})).map(f -> f.thenCombine(CompletableFuture.supplyAsync(() -> {
			Util.delay();
			return ". I'm Java8";
		}), (x, y) -> x + y + " ")).collect(Collectors.toList());
		
		collect3.stream().map(CompletableFuture::join).forEach(System.out::println);
		
		System.out.println("==================我是分割线==================");
		
		CompletableFuture[] array = list.stream().map(s -> CompletableFuture.supplyAsync(() -> {
			Util.delay();
			return "hello, " + s;})).map(f -> f.thenCompose(s -> CompletableFuture.supplyAsync(() -> {
				Util.delay();
				return s + ". I'm Java8";
			}))).map(f -> f.thenAccept(System.out::println)).toArray(CompletableFuture[]::new);
		
		//CompletableFuture.allOf(array).join(); 返回所有结果
		CompletableFuture.anyOf(array).join();   //返回一个结果即停止
	}
}
