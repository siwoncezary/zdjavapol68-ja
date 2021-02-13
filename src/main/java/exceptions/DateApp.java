package exceptions;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class DateApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Wpisz datę w postaci rrrr-mm-dd:");
            String dateStr = scanner.nextLine();
            try {
                LocalDate date = LocalDate.parse(dateStr);
                System.out.println("Poprawna data: " + date);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Niepoprawny format daty. Sprobuj jeszcze raz.");
            }
        }
    }
}
