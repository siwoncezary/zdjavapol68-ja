package solution.task5;

public class BrokenGasCar extends GasCar{

    public BrokenGasCar(double fuelCapacity) {
        super(fuelCapacity);
    }

    /*
        Zepsuć można na wiele sposób, to jeden z kilku pomimo zachowania hermetyzacji pól w klasie bazowej,
        tylko dodanie final do metod w klasie bazowej zabezpieczy przed zepsuciem obu metod
     */
    @Override
    public double refuel(double fuel) {
        if (fuel < 0) {
            return super.refuel(-fuel);
        } else {
            return super.refuel(fuel);
        }
    }

    @Override
    public double consume(double fuel) {
        if (fuel < 0) {
            return super.consume(-fuel);
        } else {
            return super.consume(fuel);
        }
    }
}
