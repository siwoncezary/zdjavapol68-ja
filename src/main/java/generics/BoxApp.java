package generics;

public class BoxApp {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>("TEST", 10);
        System.out.println(stringBox.getContent());
        Box<Integer> integerBox = new Box<>(125, 5);
        System.out.println(integerBox.getContent());
        Box<Person> personBox = new Box<>(new Person("robert", 176.6), 200);
        System.out.println(personBox.getContent());
        personBox = new Box<>(new User("robert", 176.5, "reb@gmail.com"), 250);
        System.out.println(personBox.getContent());

        Box<Boxable> universalBox = new Box<>(new User("robert", 165.5, "aa@op.pl"), 100);
        universalBox = new Box<>(new StringBoxable("TEST"), 30);


    }
}
