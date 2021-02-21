package functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

interface Transform{
    String apply(String arg);
}

public class StreamDemo {

    static public List<String> toLowerCase(List<String> list){
        List<String> result = new ArrayList<>();
        for(String s: list){
            result.add( s.toLowerCase() );
        }
        return result;
    }

    static public List<String> transform(List<String> list, Transform trans){
        List<String> result = new ArrayList<>();
        for(String s: list){
            result.add( trans.apply(s) );
        }
        return result;
    }

    static public List<String> filter(List<String> list, Predicate<String> pr){
        List<String> result = new ArrayList<>();
        for(String s: list){
            if (pr.test(s)) {
                result.add(s);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("ALA", "OLA", "EWA");
        System.out.println(toLowerCase(names));
        System.out.println(transform(names, str -> str.toLowerCase()));
        System.out.println(transform(names, str -> "imię: " + str));
        Consumer<String> consumer = name -> System.out.print(name +", ");
        names.stream().filter(name -> name.contains("L")).forEach(consumer);
        System.out.println(filter(names, name -> name.contains("L")));
        Function<String, String> toLowerCase = name -> name.toLowerCase();
        final List<String> collect = names.stream().map(toLowerCase).collect(Collectors.toList());
        System.out.println(collect);
    }
}
