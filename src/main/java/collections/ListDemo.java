package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("ADAM");
        names.addAll(Arrays.asList("ALA", "OLA", "ROBERT"));
        System.out.println(names);
        System.out.println("Metody interfejsu List");
        System.out.println("Pobranie elementu o indeksie");
        System.out.println(names.get(2));
        System.out.println("Wstawienie elementu na podanej pozycji");
        names.add(1, "BEATA");
        System.out.println(names);
        System.out.println("Usuwanie elementu z podanej pozycji");
        names.remove(0);
        System.out.println(names);
        System.out.println("Wstawienie elementów kolekcji począwszy od indeksu");
        names.addAll(2, Arrays.asList("EWA", "TOMEK"));
        System.out.println(names);
        System.out.println("Podlista, która jest widokiem listy głównej");
        List<String> subList = names.subList(2,4);
        System.out.println(subList);
        System.out.println("Dodanie elementu do podlisty");
        subList.add("XXXX");
        System.out.println("Modyfikuje całą listę");
        System.out.println(names);
        System.out.println("Tworzenie kopii listy");
        List<String> copy = new ArrayList<>(subList);
        copy.add("YYYYY");
        System.out.println(copy);
        System.out.println(subList);
    }
}
