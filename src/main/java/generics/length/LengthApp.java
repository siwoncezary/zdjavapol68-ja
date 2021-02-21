package generics.length;

public class LengthApp {
    public static void main(String[] args) {
        //Ograniczenie typów parametrów powoduje, że możemy utworzyć tylko klasy z typów pochodnych po Lenght
        UniversalLengthConverter<LengthInMeter, LengthInMile> meterToMile = new UniversalLengthConverter<>(meter -> LengthInMile.ofMeter(meter.getInMeter()));
        UniversalLengthConverter<LengthInMeter, LengthInInch> meterToInch = new UniversalLengthConverter<>(meter -> LengthInInch.ofMeter(meter.getInMeter()));
        UniversalLengthConverter<LengthInInch, LengthInMile> inchToMile = new UniversalLengthConverter<>(inch -> LengthInMile.ofMeter(inch.getInMeter()));

        System.out.println(meterToInch.convert(new LengthInMeter(5)));
        System.out.println(inchToMile.convert(new LengthInInch(10)));

    }
}
