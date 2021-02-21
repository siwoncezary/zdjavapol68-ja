package generics.length;

public class LengthInMile extends Length {

    public LengthInMile(double length) {
       super(length);
    }

    public LengthInMile(LengthInMeter meters){
        super(meters.getLength() / 0.000621371192);
    }

    @Override
    double getInMeter() {
        return 0;
    }

    public double getLength() {
        return length / 0.000621371192;
    }

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
