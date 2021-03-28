package solution.task11;

public class Pair<T, U> implements Parable<T, U>{
    private final T first;
    private final U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public T getFirst() {
        return first;
    }

    @Override
    public U getSecond() {
        return second;
    }
}
