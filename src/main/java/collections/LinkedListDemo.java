package collections;

import java.util.*;

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
        System.out.println(names);
        System.out.println("Wykorzystanie ListIterator'a");
        System.out.println("Usuwamy elementy 3 znakach");
        System.out.println("Dodajemy za elementem na literę A napis OK");
        ListIterator<String> iterator = names.listIterator();
        while(iterator.hasNext()){
            String item = iterator.next();
            System.out.println("item: " + item);
            if (item.length() == 3){
                iterator.remove();
            } else {
                if (item.startsWith("A")){
                    iterator.add("OK");
                }
            }
        }
        System.out.println(names);
        System.out.println("Przeglądanie kolekcji od końca");
        while(iterator.hasPrevious()){
            String item = iterator.previous();
            System.out.println("item[" + (iterator.previousIndex() + 1) +"]" + item);
        }
    }
}
