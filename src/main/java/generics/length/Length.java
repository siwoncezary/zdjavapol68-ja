package generics.length;

/**
 * Klasa obstrakcyjna jest klasą bazową dla klas jednostek długości
 * nie określa w jakiej jednostce jest wyrażona, ale określa typ wielkości - długość
 * Każda klasa wyprowadzona będzie określać już konkretną jednostkę tej wielkości
 */
abstract public class Length {
    final double length;

    public Length(double length) {
        this.length = length;
    }

    /**
     * Metoda abstrakcyjna pozwala na zamianę każdej długości na wartość w metrach
     * W ten sposób łatwo będzie przeliczać jednostki między sobą wg schematu
     * jednostka źródłowa -> metry -> jednostka docelowa
     * Bardziej ambitne podejście polegałoby na zwracania obiektu klasy LenghtInMeter,
     * ale trochę sobie to uprościmy ;)
     */
    abstract double getInMeter();

    public double getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "Length{" +
                "length=" + length +
                '}';
    }
}
