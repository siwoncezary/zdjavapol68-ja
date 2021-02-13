package generics;

public class Person implements Boxable<Person>{
    final String name;
    final double height;

    public Person(String name, double height) {
        this.name = name;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", height=" + height +
                '}';
    }

    @Override
    public Person getValue() {
        return this;
    }
}
