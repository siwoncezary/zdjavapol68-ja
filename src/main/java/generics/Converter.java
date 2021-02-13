package generics;

public interface Converter <T, R>{
    R convert(T value);
}
