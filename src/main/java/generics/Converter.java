package generics;

import java.util.function.Supplier;

public interface Converter <T, R>{
    R convert(T value, Supplier<R> supplier);
}
