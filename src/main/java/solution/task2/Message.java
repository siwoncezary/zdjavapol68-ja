package solution.task2;

import java.util.Objects;

abstract public class Message {
    private final String content;

    public Message(String content) {
        this.content = content;
    }

    protected boolean canSend(){
        return !isNull(content) && !isEmpty(content) && hasMinimalLength(content, 5);
    }

    abstract public String send();

    static protected boolean isNull(String input){
        return Objects.isNull(input);
    }

    static protected boolean isEmpty(String input){
        return input.isEmpty();
    }

    static protected boolean hasMinimalLength(String input, int length){
        return input.length() >= length;
    }

    public String getContent() {
        return content;
    }
}
