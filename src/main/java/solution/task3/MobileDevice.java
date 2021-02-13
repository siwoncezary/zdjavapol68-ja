package solution.task3;

abstract public class MobileDevice {
    final String producer;
    final int batteryCapacity;
    boolean isWiFi;

    public MobileDevice(String producer, int batteryCapacity) {
        this.producer = producer;
        this.batteryCapacity = batteryCapacity;
        this.isWiFi = false;
    }

    public String getProducer() {
        return producer;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public boolean isWiFi() {
        return isWiFi;
    }

    public void setWiFi(boolean wiFi) {
        isWiFi = wiFi;
    }

    abstract public String sendSMS(String sms);
}
