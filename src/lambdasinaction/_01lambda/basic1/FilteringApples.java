package lambdasinaction._01lambda.basic1;

import java.util.*;

public class FilteringApples {

	public static void main(String... args) {

		List<Apple> inventory = 
				Arrays.asList(new Apple(80, "green"), 
							  new Apple(155, "green"), 
							  new Apple(120, "red"));
		
		//filter method 호출
		//1, Anonymous  inner class
		List<Apple> list = filter(inventory, new ApplePredicate() {
			@Override
			public boolean test(Apple apple) {
				// TODO Auto-generated method stub
				return "green".equals(apple.getColor());
			}
		});
		System.out.println(list);
		
		//2. Lambda 식 사용
		List<Apple> list2 = filter(inventory, apple -> "red".equals(apple.getColor()));
		System.out.println(list2);
		
		List<Apple> list3 = filter(inventory, apple -> apple.getWeight() > 120);
		System.out.println(list3);
		
		
	}
	
	public static List<Apple> filterGreenApples(List<Apple> inventory) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if ("green".equals(apple.getColor())) {
				result.add(apple);
			}
		}
		return result;
	}

	public static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (apple.getColor().equals(color)) {
				result.add(apple);
			}
		}
		return result;
	}

	public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (apple.getWeight() > weight) {
				result.add(apple);
			}
		}
		return result;
	}

	public static List<Apple> filter(List<Apple> inventory, ApplePredicate p) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
	
	@FunctionalInterface
	interface ApplePredicate {
		public boolean test(Apple a);
	}
	
	static class AppleWeightPredicate implements ApplePredicate {
		public boolean test(Apple apple) {
			return apple.getWeight() > 150;
		}
	}

	static class AppleColorPredicate implements ApplePredicate {
		public boolean test(Apple apple) {
			return "green".equals(apple.getColor());
		}
	}

	static class AppleRedAndHeavyPredicate implements ApplePredicate {
		public boolean test(Apple apple) {
			return "red".equals(apple.getColor()) && apple.getWeight() > 150;
		}
	}
}