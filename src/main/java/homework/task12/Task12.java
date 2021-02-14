package homework.task12;

/**
 * Część 1
 * Rozbuduj klasę Dish o metody:
 * konstruktor, w którym oprócz nazwy należy podać dowolny rodzaj kolekcji ze składnikami
 * metody:
 *  addIngredient(Ingredient ingredient) - dodająca dowolny składnik do listy składników
 *  weight() - obliczająca masę całego dania
 *  calories() - obliczająca liczbę kalorii całego dania
 *  hashCode i equals, tak aby dwa obiekty Dish były równe jeśli skłądają się z takich samych składników
 *  ingredients() - zwraca listę wszystkich składników, która jest kopią pola ingredients
 *
 * Część 2
 * Rozbuduj klasę Pizza, która jest daniem o ustalonej liście składników: Cake, Tomato, Cheese (zdefiniuj brakującą klasę), dodając:
 *   - kolejne metody dodające konkretne składniki: Tomato, Cheese, która zwracają true gdy dodano składnik
 *   - każda z metod dodaje składnik tylko raz, jeśli już jest dany składnik to nie dodaje go i zwraca false
 *   - zaimplementuj metodę isReady(), która zwróci true, gdy w kolekcji ingredients znajdują się wszystkie wymagane składniki:
 *   Cake, Tomato, Cheese
 *
 * Częśc 3
 * Napisz klasy testowe dla klas Dish i Pizza, w której należy uwzględnić następujące przypadki:
 * - tworzenie dania z pusta lista składników
 * - tworzenie dania z kilkoma rodzajami kolekcji składników np. List, Set, Collection
 * - tworzenie dwóch dań o identycznych składnikach
 * - tworzenie dania z dowolnych składników
 * Testy powinny potwierdzić poprawność działania metod weigth, calories, equals w każdym podanym scenariuszu.
 */
public class Task12 {
    public static void main(String[] args) {

    }
}
