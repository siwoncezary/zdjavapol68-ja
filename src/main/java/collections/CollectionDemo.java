package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionDemo {
    public static void main(String[] args) {
        Collection<String> names = new ArrayList<>();
        System.out.println("Dodanie pojedynczego elementu.");
        names.add("ADAM");
        System.out.println("Dodanie elementów kolekcji");
        names.addAll(Arrays.asList("ALA","OLA","ROBERT"));
        System.out.println("Iteracja po kolekcji");
        for (String item: names){
            System.out.println(item);
        }
        System.out.println(names);
        System.out.println("Usunięcie imienia ADAM");
        names.remove("ADAM");
        System.out.println(names);
        System.out.println("Usunięcie imienia OLA");
        String ola = new String("ola");
        names.remove(ola);
        System.out.println(names);
        System.out.println("Czy w kolekcji jest ROBERT?");
        System.out.println(names.contains("ROBERT"));
        System.out.println("Czy kolekcja jest pusta?");
        System.out.println(names.isEmpty());
        System.out.println("Rozmiar kolekcji: " + names.size());
        System.out.println("Wyczyszczenie kolekcji");
        names.clear();
        System.out.println(names);
    }
}
