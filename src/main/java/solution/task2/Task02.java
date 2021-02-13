package solution.task2;

/**
 * Zadanie 2 (łatwe)
 * W klasie abstrakcyjnej <code>Message</code> zdefiniuj metodę o sygnaturze
 * <code>boolean canSend()<br>
 * tak, aby zwracała wartość false jeśli: <br>
 * - pole content jest równe null <br>
 * - pole content jest łańcuchem pustym <br>
 * - pole content ma mniej niż 5 znaków <br>
 * Dobierz odpowiedni modyfikator zasięgu aby:<br>
 * - metoda mogła być wywoływana w klasach potomnych <br>
 * - nie była dostępna dla pozostałych klas w tym lub innym pakiecie<br>
 * - klasy potomne mogły być tworzone w innych pakietach <br>
 * Zdefiniuj też metodę, którą umożliwi odczyt pola content w innych klasach.<br>
 * Następnie zaimplementuj w klasach potomnych (SMS, Email) metody abstrakcyjne
 * send() tak, aby: <br>
 * - zwracały komunikat w postaci (odpowiednio dla klasy): "Mail/SMS o treści XXX został wysłany na adres/numer YYY",<br>
 *   gdzie XXX to treść, a YYY adres lub numer telefonu
 * - jeśli wiadomości nie da się wysłać to zwraca komunikat: "Mail/SMS nie może zostać wysłany." <br>
 * Przyczynami niewysłania wiadomości mogą być niepoprawne: <br>
 * - adres mail: brak małpy, pusty łańcuch, null, niewystarczająca długość - co najmniej 5 znaków<br>
 * - numer telefonu: null, pusty łańcuch, zła długość - musi być dokładnie 9 znaków, niepoprawny znak - same cyfry<br>
 * - temat wiadomości: null, pusty łańcuch,<br>
 * Wskazówka<br>
 * Aby kod był czytelny możesz nadpisać w klasach potomnych metodę canSend(), żeby wykorzystać ją w implementowanej metodzie send()
 */

/**
 * Wersja dla ambitnych (średnio trudne)
 *  - metoda send() w sytuacji niemożności wysłania wiadomości zwraca komunikat: "Mail/SMS nie może został wysłany.Brak XXX",
 *  gdzie XXX to jedna z przyczyn (lub pierwsza wykryta przyczyna): brak treści, brak lub niepoprawny adres, brak lub niepoprawny temat, brak lub niepoprawny numeru telefonu.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Wersja dla wymiataczy (trudne)
 * Składowe takie jak content, emailAddress, phoneNumber, subject mogą też mieć swoją klasę bazową abstrakcyjną np. MessageComponent, która może mieć metody abstrakcyjne:
 *  - boolean isValid() - zwraca, czy zawartość jest poprawna
 *  - String getError() - zwraca komunikat z infomacją dlaczego nie jest poprawne
 *  Zdefiniuj taką klasę abstrakcyjną i odpowiednie klas potomne: PhoneNumber, EmailAddress, EmailSubject, MessageContent
 *  Zmień deninicje klasy Message:
 *  - możesz wyrzucić pole content i dodać w jego miejsce tablice obiektów MessageComponent
 *  - zmien konstruktor, aby przyjmował tablicę komponentów
 *  - możesz zdefiniować metodę canSend() - wystarczy przejrzeć całą tablicę i wywoływać metode isValid dla każdego komponentu
 *  W klasach potomnych <code>Message</code>:
 *  - sygnatury konstruktorów pozostaw takie jak teraz, zmień tylko ich definicje - musisz utworzyc obiekty komponentów, utworzyć tablicę komponentów i wywołać konstruktor klasy bazowej (da się to zrobić!!!)
 *  - możesz korzystać ze zdefiniowanej metody canSend()
 *  - jeśli wykryjesz, że wiadomości się nie da wysłać to wywołaj metodę getError dla błednego komponentu - w ten sposób masz komunikt z błędem
 */
public class Task02 {
    public static void main(String[] args) {
        Message[] messeges = {
                new SMS("Hello",""),
                new SMS("Hello","123900899"),
                new Email("Java jest super!!!","alek@op.pl","Java"),
                new Email("Java jest super!!!","alek@op.pl",""),
                new Email("Java jest super!!!",null,"Java"),
                new Email(null,"alek@op.pl","Java"),
                new Email("Java jest super!!!","alek90","Java")
        };
        for(Message m: messeges){
            System.out.println(m.send());
        }
        /**
         * Poprawne komunikaty:
         * SMS nie może zostać wysłany.
         * SMS o treści Hello został wysłany na numer 123900899
         * Mail o treściJava jest super!!! wysłany na adres alek@op.pl
         * Mail o treściJava jest super!!! wysłany na adres alek@op.pl
         * Mail nie może zostać wysłany.
         * Mail nie może zostać wysłany.
         * Mail nie może zostać wysłany.
          */
    }
}
