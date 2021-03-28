package solution.task14;

import anonymous.Callback;
import anonymous.Menu;
import anonymous.MenuItem;
import solution.task14.abook.model.AddressItem;
import solution.task14.controller.ConsoleInputController;
import solution.task14.controller.InputDataController;
import solution.task14.exceptions.*;
import solution.task14.abook.AddressBook;
import solution.task14.storage.FileAddressObjectStorage;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Napisz program, który obsługuje książkę adresową zapisywaną w pliku.
 * Format pliku jest binarny, a zapisywane są serializowane obiekty klasy
 * AddressItem. Dodaj do tej klasy odpowiedni interfejs, który umożliwia serializację.
 * Program powinien umożliwiać:
 * - dodanie nowego adresu
 * - usunięcie adresu
 * - wyświetlenie całej zawartości
 * - wyszukanie na podstawie pola name lub phoneNumber adresu lub adresów (dla pola name)
 */
public class Task14B {
    private final Scanner scanner = new Scanner(System.in);
    private boolean isExit = false;

    private Menu buildMenu(InputDataController controller, AddressBook book){
        MenuItem addAddress = new MenuItem("Dodaj wpis", 1);
        MenuItem deleteAddress = new MenuItem("Usuń wpis", 2);
        MenuItem printAddresses = new MenuItem("Wyświetl wszystko", 3);
        MenuItem findAddressByName = new MenuItem("Znajdź wpis o nazwie", 4);
        MenuItem findAddressByPhone = new MenuItem("Znajdź wpis z numerem telefonu", 5);
        MenuItem exitApp = new MenuItem("Koniec", 0);

        addAddress.setCallback(new Callback() {
            @Override
            public void action() {
                try {
                    book.add(controller.inputAddressItem());
                } catch (AddressItemInvalidBirthDateException | AddressItemInvalidNameException | AddressItemInvalidEmailException | AddressItemInvalidFullNameException | AddressItemInvalidPhoneNumberException e) {
                    System.out.println(e.getMessage());
                }
            }
        });

        exitApp.setCallback(new Callback() {
            @Override
            public void action() {
                isExit = true;
            }
        });

        printAddresses.setCallback(new Callback() {
            @Override
            public void action() {
                book.findAll().forEach(System.out::println);
            }
        });

        deleteAddress.setCallback(new Callback() {
            @Override
            public void action() {
                if (!book.delete(controller.inputDeletingAddressNumber())){
                    System.out.println("Nie ma takiej pozycji!.");
                } else {
                    System.out.println("Wpis został usunięty");
                }
            }
        });

        findAddressByName.setCallback(new Callback() {
            @Override
            public void action() {
                List<AddressItem> list = book.findByName(controller.inputName());
                if (list.size() == 0){
                    System.out.println("Brak pasujących wpisów!");
                } else{
                    System.out.println("Znalezionych wpisów: " + list.size());
                    list.forEach(System.out::println);
                }
            }
        });

        findAddressByPhone.setCallback(new Callback() {
            @Override
            public void action() {
                List<AddressItem> list = book.findByPhone(controller.inputPhone());
                if (list.size() == 0){
                    System.out.println("Brak pasujących wpisów!");
                } else{
                    System.out.println("Znalezionych wpisów: " + list.size());
                    list.forEach(System.out::println);
                }
            }
        });
        return  new Menu(new MenuItem[]{addAddress, deleteAddress, printAddresses, findAddressByName, findAddressByPhone, exitApp});
    }

    void run(String pathToFile){
        try (AddressBook book = AddressBook.build(new FileAddressObjectStorage(pathToFile))){
            InputDataController controller = new ConsoleInputController(scanner);
            Menu menuApp = buildMenu(controller, book);
            while(!isExit) {
                menuApp.print();
                while(!scanner.hasNextInt()){
                    System.out.println("Nie ma takiej opcji!!");
                    scanner.nextLine();
                }
                int itemNumber = scanner.nextInt();
                scanner.nextLine();
                menuApp.process(itemNumber);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Niepoprawna operacja plikowa lub niepoprawny format pliku. Podaj inny plik z danymi adresowymi!");
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Task14B app = new Task14B();
        app.run("c:\\data\\abook.ser");
    }
}
