package functional;

import homework.task13.Cities;
import homework.task13.City;
import homework.task13.Task13A;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.stream.Collectors;

public class StreamCityDemo {
    public static void main(String[] args) {
        List<City> cities = Cities.loadCities(StreamCityDemo.class.getResourceAsStream("../cities500.txt"));
        cities.stream().skip(1000).limit(10).forEach(System.out::println);
        OptionalLong max = cities.stream().map(city -> city.getPopulation()).mapToLong(pop -> pop).max();
        System.out.println(max.orElseGet(() -> -1));
        Optional<City> first = cities.stream().filter(city -> city.getPopulation() == 22315474).findFirst();

        first.ifPresent(city -> {
            System.out.println("Długość: " + city.getLongitude());
            System.out.println("Szerokosć: " + city.getLatitude());
        });
        if (cities.stream().anyMatch(city -> city.getName().startsWith("Nowa"))){
            System.out.println("JEST");
        }
        long count = cities.stream()
                .filter(city -> city.getCountryCode().equals("PL"))
                .peek(System.out::println)
                .filter(city -> city.getPopulation() > 10_000)
                .count();

        System.out.println("Liczba miast polskich o populacji powyżej 10 000 " + count);

        List<City> pl = cities.stream()
                .filter(city -> city.getCountryCode().equals("PL"))
                .sorted((a, b) -> Integer.compare(a.getPopulation(), b.getPopulation()))
                .limit(10)
                .collect(Collectors.toList());
        System.out.println(pl);
        long population = cities.stream()
                .filter(city -> city.getCountryCode().equals("PL"))
                .mapToLong(City::getPopulation)
                .reduce(0, (a, pop) -> a + pop);
        System.out.println("Populacja miast polskich " + population);
        Map<String, Long> collect = cities.stream().collect(Collectors.groupingBy(city -> city.getCountryCode(), Collectors.summingLong(city -> city.getPopulation())));
        System.out.println("Populacja miast polskich " + collect.get("PL"));
    }
}
