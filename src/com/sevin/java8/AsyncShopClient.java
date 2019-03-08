package com.sevin.java8;

import java.util.concurrent.Future;

public class AsyncShopClient {

	public static void main(String[] args) {
		AsyncShop shop = new AsyncShop("BestShop");
		
		long start = System.nanoTime();
		Future<Double> f = shop.getPriceAsync("myPhone");
		long incocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Invocation returned after " + incocationTime + " msecs");
        
        try {
            System.out.println("Price is " + f.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        long retrivalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrivalTime + " msecs");
	}
}
