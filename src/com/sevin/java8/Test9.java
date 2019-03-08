package com.sevin.java8;

import java.util.Arrays;
import java.util.List;

public class Test9 {
	
	public static void main(String[] args) {
		List<Point> points = Arrays.asList(new Point(12, 2), null);
		points.stream().map(p -> p.getX()).peek(n -> System.out.println(n)).forEach(System.out::println);
		
		
		
	}
	
	public static class Point{
		private final int x;
		
		private final int y;

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		public Point moveRightBy(int x) {
			return new Point(this.x + x, this.y);
		}
		
	}
}
