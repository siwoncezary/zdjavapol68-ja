package exceptions;

public class InvalidFuelLevelException extends Exception{
    private static final String DEFAULT_MESSAGE = "Komunikat staly";
    private final double fuelLevel;

    public InvalidFuelLevelException(double fuelLevel, String message) {
        super(message);
        this.fuelLevel = fuelLevel;
    }

    public InvalidFuelLevelException() {
        super(DEFAULT_MESSAGE);
        this.fuelLevel = 0;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }
}
