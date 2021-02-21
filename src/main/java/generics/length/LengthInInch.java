package generics.length;

public class LengthInInch extends Length {


    public LengthInInch(double length) {
        super(length);
    }

    @Override
    double getInMeter() {
        return this.length * 0.0254;
    }

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
