package lambdasinaction._02stream.basic2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import lambdasinaction._02stream.basic1.Dish;


public class _05Reducing {

    public static void main(String... args) {
        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);
        
        //reduce - - reduce�� ����Ͽ� sum �� ���ϴ� ���
//        int sum = numbers.stream().reduce(0, (n1, n2) -> n1 + n2).intValue();
//        int sum = numbers.stream().reduce(0, (n1, n2) -> Integer.sum(n1, n2)).intValue();
        int sum = numbers.stream().reduce(0, Integer::sum).intValue();
        System.out.println(sum);
        
        Optional<Integer> optional = numbers.stream().reduce(Integer::sum);
        optional.ifPresent(System.out::println);
        sum = optional.get();
        
        //reduce�� ����Ͽ� �ּҰ� ���ϴ� ���
        int min = numbers.stream().reduce(Integer::min).get();
        System.out.println(min);
        //reduce�� ����Ͽ� �ִ밪 ���ϴ� ���
        int max = numbers.stream().reduce(Integer::max).get();
        System.out.println(max);
        //Į�θ� �հ踦 ���ϴ� �������� ���
        //1. reduce �Լ��� ���� ����.
        int sumCalories = Dish.menu.stream()
                                   .map(dish -> dish.getCalories())
                                   .reduce(Integer::sum)
                                   .get(); 
        System.out.println(sumCalories);
        
        //2. reduce �Լ�����  Integer.sum ȣ��.
        sumCalories = Dish.menu.stream()
                               .map(Dish::getCalories)
                               .reduce(Integer::sum)
                               .get();
        //3. reduce() ������� �ʰ� mapToInt(), sum() ���
        sumCalories = Dish.menu.stream()
                               .mapToInt(dish -> dish.getCalories())
                               .sum();
        
        //�����Լ��� �Ѳ����� �����ϴ� summaryStatistics ���
        System.out.println(IntStream.rangeClosed(1, 100).summaryStatistics());
        
    }
    
}
