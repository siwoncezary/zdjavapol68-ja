package homework.task13;

import java.util.*;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.stream.Collectors;

/**
 * CZESC 1
 * Na podstawie otrzymanej kolekcji miast (obiekty klasy City) stwórz kolejne kolekcje (elementy z kolekcji kopiujemy do nowej):
 * - zbiór kodów państw, w których znajdują się miasta (kod zawarty jest w polu countryCode) (*)
 * - listę miast leżących w Polsce                                                           (*)
 * - listę miast o populacji powyżej 1_000_000                                               (*)
 * - mapę, w której kluczem jest nazwa miasta a wartością obiekt City                        (**)
 * - mapę, w której kluczem jest zaokrąglona do liczby całkowitej szerokość geograficza a wartością lista miast o takiej szerokości (***)
 * Każdy z punktów nalezy zdefiniować w osobnych metodach w postaci
 *      typ_kolekcji nazwa_metody(Collection<City> cities);
 * np.:
 *      public static Set<City> countryCodes(Collection<City> cities){
 *
 *      }
 * W funkcji main wywołaj każdą z metod i wyświetl cześć każdej otrzymanej kolekcji np. pierwszych 100 elementów
 * CZESC 2
 * Zmodyfikuj otrzymane kolekcje z punktu 1 zgodnie z poniższymi punktami:
 *  - usuń z kolekcji cities miasta o populacji mniejszej od 10_000 (*)
 *  - w kolekcji miast o populacji powyżej 1_000_000 usuń miasta niemieckie (*)
 *  - w kolekcji miast polskich, za każdym miastem, które w nazwie zawiera słowo Nowa .. dodaj miasto Stara .. np.
 *    Nowa Sól -> Stara Sól, pozostałe dane skopiuj z pasującego miasta (**)
 * W każdym zadaniu wykorzystaj iterator, także każdy z punktów umieść w osobnej metodzie, podobnie jak w części 1
 * Gwiazdkami oznaczony jest stopień trudności.
 */
public class Task13A {
    public static long sum(int a, int b){
        return a + b;
    }
    public static void main(String[] args) {
        Collection<City> cities = Cities.loadCities(Task13A.class.getResourceAsStream("../../cities500.txt"));
        for(City c: cities){
            if (c.getCountryCode().equals("PL") && c.getName().equals("Stara Sól")) {
                System.out.println(c);
            }
        }
        List<City> polishCities = cities.stream()
                .filter(city -> "PL".equals(city.getCountryCode()))
                .collect(Collectors.toList());

        long[] populationsOfLargeCities = cities.stream()
                .filter(city -> city.getPopulation() > 5_000_000)
                .mapToLong(City::getPopulation)
                .toArray();
        for(long c: populationsOfLargeCities){
            System.out.println(c);
        }
        Optional<Map.Entry<String, Long>> countryWithMaxPopulation = cities.stream()
                .collect(Collectors.groupingBy(City::getCountryCode, Collectors.summingLong(City::getPopulation)))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getValue));
        System.out.println(countryWithMaxPopulation);

        DoublePredicate isGreater = x -> x > 10.0;
        DoubleFunction<Double> fun = x -> x *10.0;
    }
}
