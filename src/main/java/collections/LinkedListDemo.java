package collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>(Arrays.asList("ALA", "OLA", "ADAM"));
        System.out.println("Dodajemy EWA na początek");
        names.addFirst("EWA");
        System.out.println("Dodajemy ROBERT na koniec");
        names.addLast("ROBERT");
        System.out.println(names);
        System.out.println("Zmiana typu referencji LinkdeList na typ List");
        List<String> namesAsList = names;
        System.out.println(names instanceof Iterable);
        System.out.println(names instanceof Collection);
        System.out.println(names instanceof List);
    }
}
