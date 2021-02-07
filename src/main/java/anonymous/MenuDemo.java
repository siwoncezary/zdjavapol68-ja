package anonymous;

import java.util.Scanner;
public class MenuDemo {
    static Scanner scanner = new Scanner(System.in);
    static int var1;
    static int var2;
    public static void main(String[] args) {
        MenuItem loadItem1 = new MenuItem("Wczytaj pierwszą zmienną", 1);
        MenuItem loadItem2 = new MenuItem("Wczytaj drugą zmienną", 2);
        MenuItem calcItem = new MenuItem("Oblicz sumę zmiennych", 3);
        MenuItem endItem = new MenuItem("Koniec", 0);
        Callback loadVar1Callback = new Callback() {
            @Override
            public void action() {
                System.out.println("Podaj liczbę 1:");
                var1 = scanner.nextInt();
            }
        };
        loadItem1.setCallback(loadVar1Callback);
        loadItem2.setCallback(new Callback() {
            @Override
            public void action() {
                System.out.println("Podaj liczbę 2:");
                var2 = scanner.nextInt();
            }
        });
        calcItem.setCallback(new Callback() {
            @Override
            public void action() {
                System.out.println("Suma obu zmiennych: " + (var1 + var2));
            }
        });
        Callback endCallback = new Callback() {
            @Override
            public void action() {
                System.exit(0);
            }
        };
        endItem.setCallback(endCallback);
        Menu menu = new Menu(new MenuItem[]{loadItem1, loadItem2, calcItem, endItem});
        while(true) {
            menu.print();
            int itemNumber = scanner.nextInt();
            menu.process(itemNumber);
        }
    }
}
