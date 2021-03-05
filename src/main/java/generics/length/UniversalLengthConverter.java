package generics.length;

import java.util.function.Function;

/**
 * Klasa tworzy konkretny konwerter tylko dla jednostek tej samej wielkości - Lenght
 * Dokończymy klasę po omówieniu interfejsów funkcyjnych
 * @param <T> - klasa długości w jednostce źródłowej
 * @param <R> - klasa długości w jednostce docelowej
 */
public class UniversalLengthConverter<T extends Length, R extends Length> implements Converter<T, R> {
    //Ta funkcja dostarcza skonwertowanej długości
    final private Function<T, R> supplier;

    public UniversalLengthConverter(Function<T , R> supplier) {
        this.supplier = supplier;
    }

    @Override
    public R convert(T value) {
        //Niestety nie możemy wywoływac kontruktora dla typu parametrycznego
        //return new R(new LengthInMeter(value.getInMeter()));
        //ale możemy przekazać do metody funkcję, która nam stworzy nowy obiekt na podstawie długości w metrach
        return supplier.apply(value);
    }
}
