package generics.length;

public class LengthInMeter extends Length {

    public LengthInMeter(double length) {
        super(length);
    }

    @Override
    double getInMeter() {
        return length;
    }

    public double getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "LengthInMeter{" +
                "length=" + length +
                '}';
    }
}
