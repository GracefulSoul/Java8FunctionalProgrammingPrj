package lambdasinaction._02stream.basic2;

import java.util.Arrays;
import java.util.List;

import lambdasinaction._02stream.basic1.Dish;

import static java.util.stream.Collectors.*;

public class _02Filtering {
    
    public static void main(String...args){
        
        // 1. Filtering with predicate ( isVegeterian() ) 
        List<Dish> vegeList = Dish.menu.stream()
                                       .filter(Dish::isVegetarian)
                                       .collect(toList());
        System.out.println(vegeList);
        
        // 2. Filtering unique elements
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        List<Integer> filteringNumbers = numbers.stream()
                                                .filter(value -> value % 2 == 0)
                                                .distinct()
                                                .collect(toList());
        System.out.println(filteringNumbers);

        //3. Truncating 3 stream ( d.getCalories() > 300 )
        List<Dish> dishesLimit3 = Dish.menu.stream()
                                           .filter(dish -> dish.getCalories() > 300)
                                           .limit(3)
                                           .collect(toList());
        System.out.println(dishesLimit3);
        

        //4. Skipping elements
        List<Dish> dishesSkip2 = Dish.menu.stream()
                                          .skip(4)
                                          .collect(toList());
        System.out.println(dishesSkip2);
        
    }
}
