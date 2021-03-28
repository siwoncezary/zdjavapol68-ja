package solution.task14.abook.model;

import solution.task14.exceptions.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.regex.Pattern;

/**
 * Klasa domeny aplikacji, czyli reprezentuje jeden wpis w książce.
 * Klasa jest dość uproszczona, chętni mogą zdefiniować osobne klasy typu ValueObject dla pól email i phone.
 *
 */
public class AddressItem implements Serializable {
    private static final long serialVersionUID = 1L;
    public final static String NAME_VALIDATION_INFO = "Nazwa nie może miec mniej niż 3 znaki!";
    public final static String FULL_NAME_VALIDATION_INFO = "Imię i nazwisko nie może mieć mniej niż 7 znaków!";
    public final static String EMAIL_VALIDATION_INFO = "Email musi mieć znak @ i co najmniej jedną kropkę oraz dopuszczalne znaki w adresie email!";
    public final static String PHONE_VALIDATION_INFO = "Numer telefonu musi mieć co najmniej 7 cyfr bez spacji!";
    public final static String DATE_VALIDATION_INFO = "Rok daty nie może być większy od 2015";
    private final String name;
    private final String fullName;
    private final String emailAddress;
    private final String phoneNumber;
    private final LocalDate birthDate;
    //RFC 5322
    private static final Pattern PATTERN = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])");

    /**
     * Konstruktor publiczny tworzący wpis bezwarunkowo, czyli nie konstoluje czy argumenty spełniają warunki poprawności
     * @param name nazwa wpisu
     * @param fullName imię i nazwiso
     * @param emailAddress adres emai
     * @param phoneNumber numer telefonu
     * @param birthDate data urodzin
     */
    public AddressItem(String name, String fullName, String emailAddress, String phoneNumber, LocalDate birthDate) {
        this.name = name;
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
    }

    /**
     * Metoda statyczna tworząca poprawny obiekt wpisu, testuje poprawność każdego argumentu.
     * Jeśli któryś argument nie spełnia warunku poprawności metod zgłasza odpowiedni wyjątek.
     * @param name nazwa wposu
     * @param fullName imię i nazwisko
     * @param emailAddress adres email
     * @param phoneNumber numer telefonu
     * @param birthDate data urodzin
     * @return utworzony obiekt AddressItem
     * @throws AddressItemInvalidNameException niepoprawna nazwa
     * @throws AddressItemInvalidFullNameException niepoprawne imię i nazwisko
     * @throws AddressItemInvalidEmailException niepoprawny email
     * @throws AddressItemInvalidPhoneNumberException niepoprawny numer telefonu
     * @throws AddressItemInvalidBirthDateException niepoprawna data urodzin
     */
    public static AddressItem of(String name, String fullName, String emailAddress, String phoneNumber, LocalDate birthDate) throws AddressItemInvalidNameException, AddressItemInvalidFullNameException, AddressItemInvalidEmailException, AddressItemInvalidPhoneNumberException, AddressItemInvalidBirthDateException {
        if (isNameValid(name)){
            throw new AddressItemInvalidNameException("Niepoprawna nazwa: " + name);
        }
        if(isFullNameValid(fullName)){
            throw new AddressItemInvalidFullNameException("Niepoprawne imię i nazwisko: " + fullName);
        }
        if(!isEmailAddressValid(emailAddress)){
            throw new AddressItemInvalidEmailException("Niepoprawny adres email: " + emailAddress);
        }
        if(isPhoneNumberValid(phoneNumber)){
            throw new AddressItemInvalidPhoneNumberException("Niepoprawny numer telefonu: " + phoneNumber);
        }
        if (isBirthDateValid(birthDate)){
            throw new AddressItemInvalidBirthDateException("Niepoprawna data urodzin: " + birthDate);
        }
        return new AddressItem(name, fullName, emailAddress, phoneNumber, birthDate);
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    /*
     Metody sprawdzające poprawność są przykładowe, powinny być realizować wymagania biznesowe
     */
    public static boolean isNameValid(String name){
        return name.isEmpty() || name.length() <= 2;
    }

    public static boolean isFullNameValid(String fullName){
        return fullName.isEmpty() || fullName.length() <= 7;
    }

    public static boolean isEmailAddressValid(String email){
        return !email.isEmpty() && PATTERN.matcher(email).matches();

    }

    public static boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.isEmpty() || phoneNumber.length() <= 8 || !phoneNumber.chars().allMatch(Character::isDigit);
    }

    public static  boolean isBirthDateValid(LocalDate birthDate){
        return birthDate.getYear() >= 2015;
    }

    @Override
    public String toString() {
        return "AddressItem{" +
                "name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
