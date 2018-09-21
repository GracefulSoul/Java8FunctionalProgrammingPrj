package lambdasinaction._02stream.basic2;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

import lambdasinaction._02stream.basic1.Dish;

public class _03Mapping {

    public static void main(String...args){
        //1. map - Dish의 name 목록만
        List<String> dishNames = Dish.menu.stream()
                                          .map(Dish::getName)
                                          .collect(toList());
        System.out.println(dishNames);
        //2. map - Colory 합계
        int sumColory = Dish.menu.stream()
                                 .map(Dish::getCalories)
                                 .reduce(0, (col1, col2) -> col1 + col2)
                                 .intValue();
        System.out.println(sumColory);
        
        // map 
        List<String> words = Arrays.asList("Hello", "World");
        List<Integer> wordLengths = words.stream()
                                         .map(String::length)
                                         .collect(toList());
        System.out.println(wordLengths);
        
        //2. map - 중복된 문자 제거한 word 리스트
        System.out.println(words.stream()
                                .map(word -> word.split(""))
                                .distinct()
                                .collect(toList()));
        
        //3. flatMap  - 중복된 문자 제거가 word 리스트
        List<String> distinctWordList = words.stream()
                                             .map(word -> word.split(""))
                                             .flatMap(Arrays::stream)
                                             .distinct()
                                             .collect(toList());
        System.out.println(distinctWordList);
        
        List<String> distinctWordList2 = words.stream()
                                              .flatMap(word -> Arrays.stream(word.split("")))
                                              .distinct()
                                              .collect(toList());
        System.out.println(distinctWordList2);
        
        // flatMap
        List<Integer> numbers1 = Arrays.asList(1,2,3,4,5);
        List<Integer> numbers2 = Arrays.asList(6,7,8);
        List<int[]> pairs =
                        numbers1.stream()
                                .flatMap((Integer i) -> numbers2.stream()
                                                       .map((Integer j) -> new int[]{i, j})
                                 )
                                .filter(pair -> (pair[0] + pair[1]) % 3 == 0)
                                .collect(toList());
        pairs.forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));
    }
    
}
