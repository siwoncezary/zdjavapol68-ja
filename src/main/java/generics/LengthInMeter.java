package generics;

public class LengthInMeter extends Length{

    public LengthInMeter(double length) {
        super(length);
    }

    @Override
    double getInMeter() {
        return 0;
    }

    public double getLength() {
        return length;
    }
}
