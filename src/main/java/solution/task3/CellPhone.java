package solution.task3;

public class CellPhone extends MobileDevice{
    final String simCard;
    final int cameraSize;

    public CellPhone(String producer, int batteryCapacity,  String simCard, int cameraSize) {
        super(producer, batteryCapacity);
        this.simCard = simCard;
        this.cameraSize = cameraSize;
    }


    public String getSimCard() {
        return simCard;
    }

    public int getCameraSize() {
        return cameraSize;
    }

    public String sendSMS(String sms) {
        if (simCard != null) {
            return "Your cellphone is sending " + sms;
        } else {
            return "Cant send. No sim card";
        }
    }
}
