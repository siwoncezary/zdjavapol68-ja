package solution.task2;

public class SMS extends Message {
    final String phoneNumber;

    public SMS(String content) {
        super(content);
        phoneNumber = "";
    }

    public SMS(String content, String phoneNumber) {
        super(content);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String send() {
        if (canSend()) {
            return "SMS o treści " + getContent() + " został wysłany numer " + phoneNumber;
        } else {
            return "SMS nie może zostać wysłany.";
        }
    }

    @Override
    protected boolean canSend() {
        return super.canSend() && isValidPhoneNumber();
    }

    private boolean isValidPhoneNumber(){
        return !isNull(phoneNumber) && !isEmpty(phoneNumber) && phoneNumber.matches("\\d{9}");
    }
}
