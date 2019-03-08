package com.sevin.java8;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import javax.swing.text.NumberFormatter;

public class AsyncShop {
	
	private final String name;
	
	private final Random random;

	public AsyncShop(String name) {
		this.name = name;
		System.out.println(name.charAt(0) * name.charAt(1) * name.charAt(2));
		random = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
	}

	private double calculatePrice(String product){
		Util.delay();
		if (true) throw new RuntimeException("product not available");
		return Util.format(random.nextDouble() * product.charAt(0) + product.charAt(1));
	}
	
	public Future<Double> getPriceAsync(String product){
		/*CompletableFuture<Double> f = new CompletableFuture<Double>();
		new Thread(() -> {
			try{
				double price = calculatePrice(product);
				f.complete(price);
			}catch(Exception e){
				f.completeExceptionally(e);
			}
		}).start();
		
		return f;*/
		
		return CompletableFuture.supplyAsync(() -> calculatePrice(product));
	}
}
