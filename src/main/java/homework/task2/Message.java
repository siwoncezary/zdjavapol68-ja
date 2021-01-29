package homework.task2;

abstract public class Message {
    private final String content;

    public Message(String content) {
        this.content = content;
    }

    abstract public String send();

}
