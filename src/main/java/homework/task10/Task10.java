package homework.task10;
/**
 * Część 1
 * W klasie EmailAddress należy zaimplementować dwie metody statyczne, które zwracają obiekt
 * EmailAdrres jeśli argumenty są poprawne. W sytuacji błędnych parametrów metody zgłaszają
 * wyjątki:
 *  - metoda of(String address) - IllegalArgumentException
 *  - metoda of(String username, String host) - IllegalUsernameException lub IllegalHostException
 *  Samodzielnie zdefiniuj dwie klasy wyjątków zgłaszanych przez metodę from
 *  Po wykonaniu zadania uruchom testy zawarte w klasie EmailAddressTest, należy tylko
 *  odkomentować jedną z metod testowych (metoda from wykorzystuje nieistniejące klasy wyjątków).
 *  Jeśli wszystkie testy przeszły pomyślnie możesz uznać, że wykonałeś zadanie poprawnie.
 *  Część 2
 *  Zmodyfikuj klasę EmailAddress, aby:
 *  - w username dopuszczalane były także cyfry, ale cyfra nie może być pierwszym znakiem
 *  - w polu host dopuszczalne były takze cyfry oprócz top domeny
 *  - jeśli w metodzie of(username, host), host zawiera niepoprawną domenę czyli np zawiera cyfrę, jest pusta itd.
 *   to zgłaszany ma być własny wyjatek IllegalTopDomainException`
 *  Po wykonaniu zadania dopisz testy w osobnej metodzie klasy EmailAddressTest. Metodę nazwij partTwo.
 */
public class Task10 {
    public static void main(String[] args) {
    }
}
