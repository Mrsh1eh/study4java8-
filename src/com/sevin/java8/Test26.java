package com.sevin.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Test26 {

	public static void main(String[] args) {
		try {
			Files.list(Paths.get("D:\\")).forEach(p -> System.out.println(p.toString()));
			System.out.println("===========================");
			//Files.walk(Paths.get("D:\\")).forEach(p -> System.out.println(p.toString()));
			
			System.out.println(0x00002000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
