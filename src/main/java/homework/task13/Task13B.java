package homework.task13;

import java.util.List;

/**
 * Napisz program konsolowy, który umożliwia przeglanie kolekcji cities. Kolekcja jest duża i zawiera prawie 200 tysięcy obiektów,
 * więc można ją przeglądać stronami - po maksymalnie 20 na stronę.
 * Funkcje programu:
 * wyświetla menu z opcjami
 * 1. Następna strona
 * 2. Poprzednia strona
 * 3. Wyświetl daną stronę
 * 0. Koniec
 * Opcja 1 powoduje, że wyświetlona zostanie nastepna strona, czyli nastepne co najmniej 20 elementów kolekcji, jeśli
 * bieżąca strona jest już ostatnia, to opcja nic nie robi
 * Opcja 2 powoduje wyświetlenie poprzedniej strony, jeśli jest to pierwsza strona to nic nie robi
 * Opcja 3 powoduje wczytanie od użytkownika numeru strony i jej wyświetlenie, jeśli wartość jest niepoprawna bp. 3000 a wszystkich stron
 * jest 2000, to wyświetlony zostanie komunikat, że taka strona nie istnieje
 * Opcja 0 powoduje wyjście z programu
 * Po wybraniu opcji 1-3 powinno nastapić wyświetlenie danej strony lub komunikatu i ponowne wyświetlenie menu
 * Do stworzenia programu możesz wykorzystać zdefiniowane klasy w pakiecie anonymous: Menu i MenuItem
 *
 * Wskazówki
 * stwórz klasę CityPaginator, z konstruktorem o argumentach: kolekcja miast i rozmiar strony, oraz metodami
 * - current(), która zwraca listę obiektów należących do bieżącej strony; nie powoduje przewijania
 * - next(), przechodzi do następnej strony i zwraca kolekcję obiektów nowej strony
 * - previous(), przechodzi do poprzedniej strony i zwraca kolekcję obiektów nowej strony
 * - reset(), ustawia przeglądanie od początku i zwraca listę obiektów pierwszej strony
 * - skip(int page) - przechodzi do podanej strony i zwraca listę obiektów tej strony
 * Samodzielnie określ co mogą zwracać metody w sytuacjach skrajnych, np. gdy bieżąca strona jest ostatnią co może zwracać
 * metoda next()
 *
 * CZESC DLA CHETNYCH
 * Zdefniuj klasę Paginator w postaci generycznej, aby działała dla dowolnej kolekcji obiektów
 */
public class Task13B {

    public static void main(String[] args) {
        List<City> cities = Cities.loadCities(Task13B.class.getResourceAsStream("../../cities500.txt"));
        for(City c: cities){
            System.out.println(c);
        }

    }
}
