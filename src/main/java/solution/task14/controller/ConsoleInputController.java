package solution.task14.controller;

import solution.task14.abook.model.AddressItem;
import solution.task14.exceptions.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * Klasa implementuje interfejs odczytu danych do aplikacji z konsoli
 */
public class ConsoleInputController implements InputDataController {
    private final Scanner scanner;

    public ConsoleInputController(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public AddressItem inputAddressItem() throws AddressItemInvalidNameException, AddressItemInvalidEmailException, AddressItemInvalidPhoneNumberException, AddressItemInvalidBirthDateException, AddressItemInvalidFullNameException {
        System.out.println("Wpisz nazwę");
        String name = scanner.nextLine();
        if(AddressItem.isNameValid(name)){
            throw new AddressItemInvalidNameException("Niepoprawne imię: " + name +"\n" + AddressItem.NAME_VALIDATION_INFO);
        }
        System.out.println("Wpisz imię i nazwisko:");
        String fullName = scanner.nextLine();
        if(AddressItem.isFullNameValid(fullName)){
            throw new AddressItemInvalidFullNameException("Niepoprawne imię i nazwisko: " + fullName +"\n" + AddressItem.FULL_NAME_VALIDATION_INFO);
        }
        System.out.println("Wpisz email:");
        String email = scanner.nextLine();
        if(!AddressItem.isEmailAddressValid(email)){
            throw new AddressItemInvalidEmailException("Niepoprawne email: " + email + "\n" + AddressItem.EMAIL_VALIDATION_INFO);
        }
        System.out.println("Wpisz numer telefonu:");
        String phone = scanner.nextLine();
        if(AddressItem.isPhoneNumberValid(phone)){
            throw new AddressItemInvalidPhoneNumberException("Niepoprawne mumer telefonu: " + phone +"\n" + AddressItem.PHONE_VALIDATION_INFO);
        }
        System.out.println("Wpisz datę urodzin: yyyy-mm-dd");
        String birthStr = scanner.nextLine();
        LocalDate birth;
        try {
            birth = LocalDate.parse(birthStr);
            if (AddressItem.isBirthDateValid(birth)){
                throw new AddressItemInvalidBirthDateException("Niepoprawna data urodzin: " + birthStr +"\n" + AddressItem.DATE_VALIDATION_INFO);
            }
        } catch (DateTimeParseException e){
            throw new AddressItemInvalidBirthDateException("Niepoprawny format daty urodzin:" + birthStr);
        }
        return new AddressItem(name, fullName, email, phone, birth);
    }

    @Override
    public int inputDeletingAddressNumber() {
        System.out.println("Wpisz numer pozycji do usunięcia");
        if (scanner.hasNextInt()){
            int index = scanner.nextInt();
            scanner.nextLine();
            return index;
        }
        return -1;
    }

    @Override
    public String inputName() {
        System.out.println("Wpisz szukaną nazwę lub jej fragment");
        return scanner.nextLine();
    }

    @Override
    public String inputPhone() {
        System.out.println("Wpisz szukany numer telefonu lub jego fragment");
        return scanner.nextLine();
    }
}
