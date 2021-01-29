package homework.task2;

public class Email extends Message{
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
        return null;
    }

}
