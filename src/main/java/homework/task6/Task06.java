package homework.task6;

/**
 * Zdefiniuj jedną z poniższych klas typu Value Object
 * 1. Klasa EmailAddress przechowująca poprawny adres email (jedna @, co najmniej jedna kropka za @, tylko znaki alfanumeryczne)
 *    z metodami zwracającymi cały adres i składowe adresu:
 *    - get() - zwraca cały adres
 *    - username() - ciąg znaków przed @
 *    - host() - ciąg znaków za @
 *    - topDomain() - najwyższą domenę, czyli ciąg znaków za ostanią kropką
 * 2. Klasa HumanTemperature przechowująca temperaturę człowieka (zakres wartości od 20 do 43 stopni)
 *    metody:
 *    - get() zwraca temperaturę w stopniach Celsjusza (double lub float)
 *    - getKelvin() - temperatura w stopniach Kelvina (double lub float)
 *    - getFahrenheit() - temperatury w stopniach Fahrenheita (double lub float)
 *    - isNormal() - zwraca true jeśli mieści się w granicach miedzy 36-37 stopni Celsjusza
 *    - format() - zwraca łańcuch z temperaturą i symbolem jednostki °C z dwoma miejscami po przecinku np. 36,85 °C
 * 3. Klasa Pesel przechowująca poprawny nr pesel (11 cyfr, poprawna data urodzin, poprawna cyfra kontrolna)
 *    metody:
 *    - birthDate() - zwraca datę urodzin zawarta w peselu
 *    - get() - zwraca łańcuch z peselem
 *    - isMale() - zwraca tru jeśli osoba jest mężczyzną
 *    - isFemale() - zwraca true jeśli osoba jest kobietą
 * Wszystkie klasy nie mogą udostępniać żadnego konstruktora, tworzenie obiektu odbywa się metodą statyczną of, na razie
 * w przypadku niemożności utworzenia poprawnego obiektu metody of niech zwracają wartość null (wrócimy do nich później, żeby to poprawić)
 */
public class Task06 {
    public static void main(String[] args) {

    }
}
