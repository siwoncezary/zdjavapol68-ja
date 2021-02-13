package generics;

public class ConverterDemo {
    public static void main(String[] args) {
        Converter<LengthInMeter, LengthInMile> converter = new LengthConverter();
        converter.convert(new LengthInMeter(350));
    }
}
