package functional;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class Person{
    final String name;
    final int point;

    public Person(String name, int point) {
        this.name = name;
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }
}

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        //PREDYKATY
        //DEFINIUJEMY PREDYKT, p jest tylko parametrem metody
        Predicate<Person> isPointGreaterThan10 = p -> p.getPoint() > 10;
        Person person = new Person("ADAM", 34);
        if (person.getPoint() > 10){
            System.out.println("OK");
        }
        Predicate<Person> filter = isPointGreaterThan10;
        //WYWOLUJEMY PREDYKAT, podajemy argument, konkretny obiekt
        if (filter.test(person)){
            System.out.println("OK");
        }
        filter = p -> p.getName().contains("A");
        if (filter.test(person)){
            System.out.println("OK");
        }

        //SUPPLIER
        /**
         *  Person get(){
         *      return new Person("ADA", 3);
         *  }
         */
        Supplier<Person> createPerson = () -> new Person("ADA", 3);
        //CONSUMER
        /**
         * void accept(Person p){
         *  System.out.println("Imie: " + p.getName()+", punkty: " + p.getPoint())
         * }
         */
        Consumer<Person> print = p -> System.out.println("Imie: " + p.getName()+", punkty: " + p.getPoint());
        print.accept(person);

        //FUNCTION
        /**
         * int apply(Person p){
         *  return p.getPoint() * 10;
         * }
         */
        Function<Person, Integer> points = p -> p.getPoint() * 10;
        System.out.println(points.apply(person));



    }
}
