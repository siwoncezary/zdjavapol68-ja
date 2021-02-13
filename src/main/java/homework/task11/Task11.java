package homework.task11;
/**
 * W bieżącym pakiecie znajdują się trzy klasy, które opisują parę dwóch obiektów
 * Zdefiniuj na podstawie tych klas klasę generyczną Pair, dzięki której będzie można
 * utworzyć obiekty zawierające parę dwóch dowolnych obiektów.
 * Zdefiniuj też interfejs generyczny Parable, który powinna implementować zdefiniowana klasa generyczna
 * Sprawdź działanie swoich klas usuwając komentarze w metodzie main
 */
public class Task11 {
    public static void main(String[] args) {
        IntegerPair integerPair1 = new IntegerPair(10, 5);
        System.out.println(integerPair1.getFirst());
        System.out.println(integerPair1.getSecond());
//        Pair<Integer, Integer> integerPair2 = new Pair<>(10, 5);
//        System.out.println(integerPair2.getFirst());
//        System.out.println(integerPair2.getSecond());
//        Parable<Integer, Integer> integerPair3 = new Pair<>(10, 5);
//        System.out.println(integerPair3.getFirst());
//        System.out.println(integerPair3.getSecond());
//        Pair<String, Character> pair4 = new Pair<>("TEST",'@');
//        System.out.println(pair4.getFirst());
//        System.out.println(pair4.getSecond());
    }
}
