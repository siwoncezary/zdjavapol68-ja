package solution.task3;

public class SmartWatch extends MobileDevice{
    final String strapColor;
    boolean isWiFi;

    public SmartWatch(String producer, int batteryCapacity, String strapColor) {
        super(producer, batteryCapacity);
        this.strapColor = strapColor;
    }

    public int maxWorkTime(int consumptionPerHour){
        return batteryCapacity/consumptionPerHour;
    }

    public String getStrapColor() {
        return strapColor;
    }

    public String sendSMS(String sms){
        if (isWiFi){
            return "Your smartwatch is Sending " + sms;
        } else {
            return "Cant send. Turn on Wifi";
        }
    }
}
