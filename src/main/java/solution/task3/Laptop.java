package solution.task3;

public class Laptop extends MobileDevice{
    final String dvdDrive;
    final int powerSupply;

    public Laptop(String producer, int batteryCapacity, String dvdDrive, int powerSupply) {
        super(producer, batteryCapacity);
        this.dvdDrive = dvdDrive;
        this.powerSupply = powerSupply;
    }

    public int maxWorkTime(int consumptionPerHour){
        return batteryCapacity/consumptionPerHour;
    }

    public String getDvdDrive() {
        return dvdDrive;
    }

    public int getPowerSupply() {
        return powerSupply;
    }

    @Override
    public String sendSMS(String sms){
        if (isWiFi){
            return "Your laptop is sending " + sms;
        } else {
            return "Cant send. Turn on Wifi";
        }
    }
}
