package generics.length;

import java.util.function.Function;

/**
 * Uniwersalny interfejs konwertera, który na podstawie obiektu T tworzy nowy obiekt R
 * @param <T>  jednostka wejściowa
 * @param <R>  jednostka do której dokonujemy konwersję
 */
public interface Converter <T, R>{
    R convert(T value);
}
