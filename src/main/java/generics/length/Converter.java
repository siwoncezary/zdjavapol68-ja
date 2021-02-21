package generics.length;

import java.util.function.Function;

public interface Converter <T, R>{
    R convert(T value);
}
