package solution.task13;

import anonymous.Callback;
import anonymous.Menu;
import anonymous.MenuItem;
import solution.task13.paging.ListPaging;
import solution.task13.paging.Paging;

import java.util.List;
import java.util.Scanner;

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
 * <p>
 * Wskazówki
 * stwórz klasę CityPaginator, z konstruktorem o argumentach: kolekcja miast i rozmiar strony, oraz metodami
 * - current(), która zwraca listę obiektów należących do bieżącej strony; nie powoduje przewijania
 * - next(), przechodzi do następnej strony i zwraca kolekcję obiektów nowej strony
 * - previous(), przechodzi do poprzedniej strony i zwraca kolekcję obiektów nowej strony
 * - reset(), ustawia przeglądanie od początku i zwraca listę obiektów pierwszej strony
 * - skip(int page) - przechodzi do podanej strony i zwraca listę obiektów tej strony
 * Samodzielnie określ co mogą zwracać metody w sytuacjach skrajnych, np. gdy bieżąca strona jest ostatnią co może zwracać
 * metoda next()
 * <p>
 * CZESC DLA CHETNYCH
 * Zdefniuj klasę Paginator (Paging) w postaci generycznej, aby działała dla dowolnej kolekcji obiektów
 */
public class Task13B {
    private final Paging<City> paging;
    private final static Scanner scanner = new Scanner(System.in);

    public Task13B(List<City> cities, int pageSize) {
        this.paging = new ListPaging<>(cities, pageSize);
    }


    private Menu buildMenu() {
        MenuItem next = new MenuItem("Następna strona", 1);
        MenuItem previous = new MenuItem("Poprzednia strona", 2);
        MenuItem skip = new MenuItem("Przejdź do strony", 3);
        MenuItem info = new MenuItem("Informacje", 4);
        MenuItem exit = new MenuItem("Następna strona", 0);
        Menu menu = new Menu(new MenuItem[]{next, previous, skip, info, exit});
        next.setCallback(new Callback() {
            @Override
            public void action() {
                paging.next().forEach(System.out::println);
            }
        });
        previous.setCallback(new Callback() {
            @Override
            public void action() {
                paging.previous().forEach(System.out::println);
            }
        });
        skip.setCallback(new Callback() {
            @Override
            public void action() {
                System.out.println("Podaj stronę:");
                if (scanner.hasNextInt()) {
                    int page = scanner.nextInt();
                    paging.skip(page).forEach(System.out::println);
                } else {
                    System.out.println("Wpisz poprawną liczbę z numerem strony!");
                }
            }
        });
        exit.setCallback(new Callback() {
            @Override
            public void action() {
                System.exit(0);
            }
        });
        info.setCallback(new Callback() {
            @Override
            public void action() {
                System.out.println("Liczba stron: " + paging.size());
                System.out.println("Bieżąca strona: " + paging.currentPageNumber());
                System.out.printf("Liczba elementów kolekcji: %,d\n", paging.itemsCount());
            }
        });
        return menu;
    }

    private void run() {
        Menu menuApp = buildMenu();
        while (true) {
            menuApp.print();
            while (!scanner.hasNextInt()) {
                System.out.println("Nie ma takiej opcji!!");
                scanner.nextLine();
            }
            int itemNumber = scanner.nextInt();
            scanner.nextLine();
            menuApp.process(itemNumber);
        }
    }

    public static void main(String[] args) {
        List<City> cities = Cities.loadCities(Task13B.class.getResourceAsStream("../../cities500.txt"));
        Task13B app = new Task13B(cities, 20);
        app.run();
    }
}
