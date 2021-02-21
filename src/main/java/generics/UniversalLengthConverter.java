package generics;

import java.util.function.Supplier;

/**
 * Dodkończymy klasę po omówieniu intrefejsów funkcyjnych
 * @param <T> - klasa długości w jednostce źródłowej
 * @param <R> - klasa długości w jednostce docelowej
 */
public class UniversalLengthConverter<T extends Length, R extends Length> implements Converter<T, R> {

    @Override
    public R convert(T value, Supplier<R> supplier) {
        //Niestety nie możemy wywoływac kontruktora dla typu parametrycznego
        //return new R(new LengthInMeter(value.getInMeter()));

        return supplier.get();
    }
}
