package lambdasinaction._01lambda.basic2;

import java.util.*;
import java.util.function.Predicate;

public class FilteringApples{
	
    public static void main(String ... args){
        
        List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
                                              new Apple(155, "green"),
                                              new Apple(120, "red"));    
        
        // 람다식 사용 [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        System.out.println(filterApples(inventory, apple -> "green".equals(apple.getColor())));
        
        // 람다식 사용[Apple{color='green', weight=155}]
        System.out.println(filterApples(inventory, apple -> apple.getWeight() > 150));
        
        // Method Reference 사용 [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        System.out.println(filterApples(inventory, FilteringApples::isGreenApple));
        
        // Method Reference 사용 [Apple{color='green', weight=155}]
        System.out.println(filterApples(inventory, FilteringApples::isHeavyApple));
        
        // []
        List<Apple> weirdApples = filterApples(inventory, (Apple a) -> a.getWeight() < 80 || 
                                                                       "brown".equals(a.getColor()));
        System.out.println(weirdApples);
        
        Predicate<Apple> redApples = apple -> "red".equals(apple.getColor());
        System.out.println(filterApples(inventory, redApples));
        
        Predicate<Apple> notRedApples = redApples.negate();
        System.out.println(filterApples(inventory, notRedApples));
        
        Predicate<Apple> redHeavyApples = redApples.and(apple -> apple.getWeight() > 100);
        System.out.println(filterApples(inventory, redHeavyApples));
    }
    
    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }
    
    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }
    
    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if(p.test(apple)) {
                result.add(apple);
            };
        }
        return result;
    }
}
