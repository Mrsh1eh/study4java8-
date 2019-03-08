package com.sevin.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import static java.util.stream.Collectors.*;

public class Test5 {

	public static void main(String[] args) {
		
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300), 
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),	
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );
		
		//找出2011年发生的所有交易，并按交易额排序（从低到高）
		transactions.stream().filter(t -> t.getYear() == 2011)
							 .sorted(Comparator.comparing(Transaction::getValue))
							 .forEach(System.out::println);
							 //.collect(Collectors.toList());生成列表
		
		//交易员都在哪些不同的城市工作过
		transactions.stream().map(t -> t.getTrader().getCity())
							 .distinct()
							 //.collect(Collectors.toList())
							 .forEach(System.out::println);
		
		Set<String> collect = transactions.stream().map(t -> t.getTrader().getCity())
							 //.distinct()
							 //.collect(Collectors.toList())
							 //.forEach(System.out::println);
							 .collect(toSet());
		System.out.println(collect);
		
		System.out.println("============================================");
		
		//查看所有来自剑桥的交易员，并按姓名排序
		transactions.stream().map(Transaction::getTrader)
							 .filter(t -> "Cambridge".equals(t.getCity()))
							 .sorted(Comparator.comparing(Trader::getName))
							 .distinct()
							 .forEach(System.out::println);
		
		System.out.println("============================================");
		
		//返回所有交易员的姓名字符串，并按字母排序
		transactions.stream().map(t -> t.getTrader().getName())
		   					 .distinct()
		   					 .sorted()
		   					 .reduce(String::concat)
		   					 .ifPresent(System.out::println);
		
		String n1 = transactions.stream().map(t -> t.getTrader().getName())
							 .distinct()
							 .sorted()
							 .collect(joining());
		System.out.println("n1 : " + n1);
		
		System.out.println("============================================");
		
		//有没有交易员在米兰工作的
		transactions.stream().filter(t -> "Milan".equals(t.getTrader().getCity()))
							 .findAny()
							 .ifPresent(System.out::println);
		
		System.out.println("============================================");
		
		//打印生活在剑桥的交易员的所有交易额
		transactions.stream().filter(t -> "Cambridge".equals(t.getTrader().getCity()))
		  					 .map(Transaction::getValue)
		  					 .reduce(Integer::sum)
		  					 .ifPresent(System.out::println);
		  				
		System.out.println("============================================");
		
		//所有交易额中，最高的交易额是多少
		transactions.stream().map(Transaction::getValue)
							 .reduce(Integer::max)
							 .ifPresent(System.out::println);
		
		System.out.println("============================================");
		
		//找到交易额最小的交易
		transactions.stream().filter(t -> {
			Integer num = transactions.stream().map(Transaction::getValue)
								 .reduce(Integer::min)
								 .orElse(0);
			return t.getValue() == num;
			
		}).findAny().ifPresent(System.out::println);
		
		transactions.stream().reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2).ifPresent(System.out::println);
		
		transactions.stream().min(Comparator.comparing(Transaction::getValue)).ifPresent(System.out::println);
							 

		//按工作地点分组
		Map<Integer, List<Transaction>> c1 = transactions.stream().collect(groupingBy(Transaction::getYear));
		System.out.println(c1);
	}
}
