package generics;

public class Box<T>{
    final T content;
    final double weight;

    public Box(T content, double weight) {
        this.content = content;
        this.weight = weight;
    }

    public T getContent(){
        return content;
    }

    public double getWeight() {
        return weight;
    }
}
