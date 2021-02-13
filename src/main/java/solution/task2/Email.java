package solution.task2;

public class Email extends Message {
    final String  emailAddress;
    final String subject;

    public Email(String content) {
        super(content);
        emailAddress = "";
        subject = "";
    }

    public Email(String content, String emailAddress, String subject) {
        super(content);
        this.emailAddress = emailAddress;
        this.subject = subject;
    }

    @Override
    public String send() {
        if (canSend()) {
            return "Mail o treści " + getContent() + " został wysłany na adres " + emailAddress;
        } else {
            return "Mail nie może zostać wysłany.";
        }
    }

    @Override
    protected boolean canSend() {
        return super.canSend() && isEmailAddressValid() && isSubjectValid();
    }

    private boolean isEmailAddressValid(){
        return !isNull(emailAddress) && !isEmpty(emailAddress) && hasMinimalLength(emailAddress, 5) && hasOneAtSymbol(emailAddress);
    }

    private boolean isSubjectValid(){
        return !isNull(subject) && !isEmpty(subject);
    }

    static protected boolean hasOneAtSymbol(String input){
        return input.indexOf('@') == input.lastIndexOf('@') && input.indexOf('@') >= 0;
    }
}
