package homework.task10;
/**
 * Część 1
 * W klasie EmailAddress należy zaimplementować dwie metody statyczne, które zwracają obiekt
 * EmailAdrres jeśli argumenty są poprawne. W sytuacji błędnych parametrów metody zgłaszają
 * wyjątki:
 *  - metoda of(String address) - IllegalArgumentException
 *  - metoda of(String login, String host) - IllegalLoginException lub IllegalHostException
 *  Samodzielnie zdefiniuj dwie klasy wyjątków zgłaszanych przez metodę from
 *  Część 2
 *  Zmodyfikuj klasę EmailAddress, aby:
 *  - w username dopuszczalane były także cyfry
 *  - w polu host dopuszczalne były takze cyfry oprócz top domeny
 *  - jeśli w metodzie of(username, host), host zawiera niepoprawną domenę czyli np zawiera cyfrę, jest pusta itd.
 *   to zgłaszany ma być własny wyjatek IllegalTopDomainException
 */
public class Task10 {
    public static void main(String[] args) {
    }
}
