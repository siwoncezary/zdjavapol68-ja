package generics.length;

public class LengthInMile extends Length {

    /**
     *Konstruktor tworzy długość w milach
     * @param length długość w milach
     */
    public LengthInMile(double length) {
       super(length);
    }

    public LengthInMile(LengthInMeter meters){
        super(meters.getLength() / 0.000621371192);
    }

    @Override
    double getInMeter() {
        return length / 0.000621371192;
    }

    /**
     * Metoda statyczna pozwala na stworznie długości w danej jednostce
     * na podstawie długości w metrach pisanej w typie double
     * @param meters długość w metrach
     * @return obiekt z długością w milach
     */
    static public LengthInMile ofMeter(double meters){
        return new LengthInMile(meters * 0.000621371192);
    }

    @Override
    public String toString() {
        return "LengthInMile{" +
                "length=" + length +
                '}';
    }
}
