package solution.task14.abook;

import solution.task14.abook.model.AddressItem;
import solution.task14.storage.Storage;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

/**
 * Klasa wykorzystuje interfejs AutoCloseable, czyli posiada metodę close
 * Utworzenie obiektu tej klasy w klauzuli try ... with  -- resource, powoduje, że
 * po opuszczeniu bloku try automatycznie wywoływana jest metoda close(), w której wykonuje sie zapis do pliku.
 * Jeśli obiekt zostanie utworzony poza tym blokiem, to należy jawnie wywołać metode close(), aby zapisać książkę.
 */
public class AddressBook implements AutoCloseable {
    /**
     * Typ referencji pola jest interfesem, więc klasa może korzystać z różnych implementacji Storage
     */
    private final Storage<AddressItem> storage;
    private final List<AddressItem> items;

    private AddressBook(Storage<AddressItem> storage) throws IOException, ClassNotFoundException {
        this.storage = storage;
        this.items = storage.load();
    }

    /**
     * Metoda statyczna zwracająca obiekt książki adresowej
     * @param storage obiekt implementujący interfejs Storage, do którego będzie zapisywana książka
     * @return zwraca obiekt AddressBook z  wczytanymi danymi z obiektu Storage
     * @throws IOException wyjątek operacji wejścia wyjścia
     * @throws ClassNotFoundException wyjątek zgłaszany, gdy brak klasy zapisanej w pliku
     */
    public static AddressBook build(Storage<AddressItem> storage) throws IOException, ClassNotFoundException {
        return new AddressBook(storage);
    }

    public void add(AddressItem item){
        items.add(item);
    }

    /**
     * Usuwa z kolekcji wpis o podanynm numerze
     * @param i numer usuwanego wpisu
     * @return true jeśli usunięcie się powiodło, false gdy usunięcie ni ebyło możliwe - niepoprawnym numer wpisu
     */
    public boolean delete(int i){
        if (i < 0 || i >= items.size()){
            return false;
        }
        items.remove(i);
        return true;
    }

    /**
     * Wyszukuje w ksiące wpis o podanym indeksie. Metoda zwraca listę, choć wiadomo, że może być
     * co najwyżej jeden wpis o szukanym numerze, ale w przypadku, gdy nie zostanie znaleziony wpis
     * zwraca jest lista, a nie wartość null. To jeden ze sposób uniknięcia NPE.
     * Przykład ilustruje wykorzystanie klasy Collections, która zwraca listę na jeden element lub listę pustą.
     * Jesto to wydajnieszy sposób od tworzenia obiektów listy np. new ArrayList(). Zwracane kolekcje są niemutowalne.
     * @param i numer wpisu
     * @return lista  znalezionych wpisów
     */
    public List<AddressItem> findByIndex(int i){
        if (i >=0 && i < items.size()){
            return Collections.singletonList(items.get(i));
        }
        return Collections.emptyList();
    }

    /**
     * Wyszukuje w książce wpisy, które zawierają w polu name przekazany fragment tekstu
     * @param name szukany fragment nazwy wpisu
     * @return lista wyszukanych elementów
     */
    public List<AddressItem> findByName(String name){
        List<AddressItem> result = new ArrayList<>();
        for(AddressItem item: items){
            if (item != null && item.getName().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT))){
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Zwraca wszystkie elementy książki w postaci strumienia, dzięki czemu nie jest możliwe zmodyfikowanie
     * na zewnątrz elementów książki
     * @return strumień elementów książki
     */
    public Stream<AddressItem> findAll(){
        return items.stream();
    }

    /**
     * Wyszukuje w książce wszystkich wpisów z numerem telefonu pasujących do fragmentu w phone
     * @param phone fragment sszukanego nuemru telefonu
     * @return lista znalezionych wpisów
     */
    public List<AddressItem> findByPhone(String phone){
        List<AddressItem> result = new ArrayList<>();
        for(AddressItem item: items){
            if (item != null && item.getPhoneNumber().contains(phone)){
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Ta metoda jest wywoływana automatycznie w konstrukcji try .. with .. resources, gdy wystąpi wyjątek
     * lub nastąpi normalne wyjście z tego bloku. Metoda wywołuje zapis danych do obiektu storage
     * @throws IOException wyjątek zgłaszany podczas operacji wejścia - wyjścia
     */
    @Override
    public void close() throws IOException {
        storage.save(items);
    }
}
