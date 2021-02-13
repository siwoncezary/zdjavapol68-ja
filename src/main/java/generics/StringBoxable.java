package generics;

public class StringBoxable implements Boxable<String>{
    final String str;

    public StringBoxable(String str) {
        this.str = str;
    }

    @Override
    public String getValue() {
        return str;
    }
}
