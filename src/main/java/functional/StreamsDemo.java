package functional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsDemo {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("Adam", "Ewa", "Tomek", "Ala");
        Stream<String> longNames = stringStream.filter(name -> {
                    System.out.println("Filter");
                    return name.length() > 3;
                }
        ).filter(name -> name.startsWith("A"));
        longNames.forEach(name -> System.out.println(name));
        List<String> strings = IntStream.range(1, 100)
                .limit(40)
                .skip(10)
                .map(x -> 2 * x + 3)
                .mapToObj(y -> Integer.toString(y, 16))
                .collect(Collectors.toList());
        System.out.println(strings);
        //Odpowiednik
//        List<String> results = new ArrayList<>();
//        for(int x = 1; x < 100; i++){
//            int y = 2 * x + 3;
//            String str = Integer.toString(y, 16);
//            results.add(str);
//        }
        //stringStream.map(name -> name.length()).distinct().forEach(name -> System.out.println(name));
        Stream.of("ALA","ADAM","ALA").map(String::length).distinct().forEach(System.out::println);


    }
}
