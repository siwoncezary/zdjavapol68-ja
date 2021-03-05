package generics.length;

/**
 * Klasa długości wyrażonejw w metrach
 */
public class LengthInMeter extends Length {
    /**
     * Konstruktor długości w metrach
     * @param length długośc
     */
    public LengthInMeter(double length) {
        super(length);
    }

    @Override
    double getInMeter() {
        return length;
    }


    @Override
    public String toString() {
        return "LengthInMeter{" +
                "length=" + length +
                '}';
    }
}
