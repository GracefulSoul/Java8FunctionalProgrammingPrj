package lambdasinaction._02stream.basic2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import lambdasinaction._02stream.basic1.Dish;


public class _05Reducing {

    public static void main(String... args) {
        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);
        
        //reduce - - reduce를 사용하여 sum 을 구하는 방법
//        int sum = numbers.stream().reduce(0, (n1, n2) -> n1 + n2).intValue();
//        int sum = numbers.stream().reduce(0, (n1, n2) -> Integer.sum(n1, n2)).intValue();
        int sum = numbers.stream().reduce(0, Integer::sum).intValue();
        System.out.println(sum);
        
        Optional<Integer> optional = numbers.stream().reduce(Integer::sum);
        optional.ifPresent(System.out::println);
        sum = optional.get();
        
        //reduce를 사용하여 최소값 구하는 방법
        int min = numbers.stream().reduce(Integer::min).get();
        System.out.println(min);
        //reduce를 사용하여 최대값 구하는 방법
        int max = numbers.stream().reduce(Integer::max).get();
        System.out.println(max);
        //칼로리 합계를 구하는 여러가지 방법
        //1. reduce 함수를 직접 구현.
        int sumCalories = Dish.menu.stream()
                                   .map(dish -> dish.getCalories())
                                   .reduce(Integer::sum)
                                   .get(); 
        System.out.println(sumCalories);
        
        //2. reduce 함수에서  Integer.sum 호출.
        sumCalories = Dish.menu.stream()
                               .map(Dish::getCalories)
                               .reduce(Integer::sum)
                               .get();
        //3. reduce() 사용하지 않고 mapToInt(), sum() 사용
        sumCalories = Dish.menu.stream()
                               .mapToInt(dish -> dish.getCalories())
                               .sum();
        
        //집계함수를 한꺼번에 제공하는 summaryStatistics 사용
        System.out.println(IntStream.rangeClosed(1, 100).summaryStatistics());
        
    }
    
}
