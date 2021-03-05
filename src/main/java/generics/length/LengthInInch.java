package generics.length;

/**
 * Klasa długości przechowywanej w calach
 */
public class LengthInInch extends Length {

    /**
     * Konstruktor długości w calach
     * @param length długość w calach
     */
    public LengthInInch(double length) {
        super(length);
    }

    @Override
    double getInMeter() {
        return this.length * 0.0254;
    }

    /**
     * Metoda wytwórcza długości w calach na podstawie długości w metrach
     * @param meter długość w metrach
     * @return obiekt długości w calach
     */
    static public LengthInInch ofMeter(double meter){
        return new LengthInInch(meter / 0.0254);
    }

    @Override
    public String toString() {
        return "LengthInInch{" +
                "length=" + length +
                '}';
    }
}
