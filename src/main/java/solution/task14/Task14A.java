package solution.task14;

import java.io.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * CZĘŚĆ 1
 * W pliku task14.txt znajduje się tekst. Wczytaj go i policz:
 * - liczbę słów
 * - liczbę wierszy
 * - liczbę słów 4-literowych
 * - liczbę słów, które są liczbami (całkowite lub dziesiętne np. 12, 34.45 itd.)
 *
 * CZĘŚĆ 2
 * Zapisz do pliku out_task14.txt wyniki uzyskane z części 1 plus:
 * - listę słów 4-literowych
 * - listę wszystkich liczb
 * Lokalizację pliku out_task14.txt możesz wybrać dowolną np. w bieżącym katalogu
 */
public class Task14A {
    public static void main(String[] args) throws IOException {
        //W taki sposób tworzymy strumień wejściowy do plików w katalogu resources
        //InputStream input = Task14A.class.getResourceAsStream("../../task114.txt");
        //sekwencja ../ powoduje przejście o katalog wyżej
        //dwie sa konieczne ponieważ każdy pakiet to katalog, a mamy pakiet task14 w pakiecie homework
        System.out.print("Liczba słów: ");
        System.out.println(countWords(Task14A.class.getResourceAsStream("../../task14.txt")));
        System.out.print("Liczba wierszy: ");
        System.out.println(countLines(Task14A.class.getResourceAsStream("../../task14.txt")));
        System.out.print("Liczba słów 4-literowych: ");
        System.out.println(countWordsWithLength(Task14A.class.getResourceAsStream("../../task14.txt"), 4));
        System.out.print("Liczba liczb: ");
        System.out.println(countNumbers(Task14A.class.getResourceAsStream("../../task14.txt")));
    }

    /*
      Rozwiązanie
      Przyjmujemy za słowa ciągi znaków pomiędzy spacjami (ignorujemy znaki przestankowe, nawiasy itd)
     */

    public static long countWords(InputStream input) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        long result = reader.lines()
                .flatMap(line -> Stream.of(line.split(" ")))
                .count();
        input.close();
        return result;
    }

    public static long countLines(InputStream input) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        long result = reader.lines()
                .count();
        input.close();
        return  result;
    }

    public static long countWordsWithLength(InputStream input, int length) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        long result = reader.lines()
                .flatMap(line -> Stream.of(line.split(" ")))
                .filter(w -> w.length() == length && w.matches(""))
                .peek(w -> System.out.println(w))
                .count();
        input.close();
        return  result;
    }

    public static long countNumbers(InputStream input) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        long result = reader.lines()
                .flatMap(line -> Stream.of(line.split(" ")))
                .filter(w -> {
                    try{
                        double d = Double.parseDouble(w);
                        return true;
                    } catch (NumberFormatException e){
                        return false;
                    }
                })
                .count();
        input.close();
        return  result;
    }
}
