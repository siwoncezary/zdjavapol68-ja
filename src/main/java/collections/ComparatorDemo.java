package collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorDemo {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("ADAM", LocalDate.of(2000,10,10), 172));
        people.add(new Person("EWA", LocalDate.of(2004,11,1), 156));
        people.add(new Person("ADAM", LocalDate.of(2001,11,10), 179));
        System.out.println(people);
        Collections.sort(people);
        System.out.println(people);
        Collections.sort(people, (p1, p2) -> p2.birthDate.compareTo(p1.birthDate));
        System.out.println(people);
        Collections.sort(people, (p1, p2) -> Integer.compare(p2.height, p1.height));
        System.out.println();
    }
}
