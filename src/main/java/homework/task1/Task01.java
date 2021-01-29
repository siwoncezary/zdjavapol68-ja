package homework.task1;

import java.time.LocalDate;

/**
 *Zadanie 1 (łatwe)
 *Zmieniając tylko prawą stronę przypisania w wierszu 15 (z komentarzem na końcu), zmień działanie programu, aby wyświetlał się napis
 *"Bohater XXX urodzony w dd-mm-yyyy"
 *gdzie XXX oraz dd-mm-yyyy to kolejno pola <code>name</code> i <code>birthDate</code> obiektu klasy <code>Person</code>
 *Reszta tej klasy oraz klasa <code>Person</code> nie może być zmieniana!!!
 *Możesz za to tworzyć nowe klasy:-)
 */
public class Task01 {
    public static void main(String[] args) {
        Person hero = new Person("Batman" , LocalDate.of(1980,10,10)); //ZMIEN TYLKO PRAWĄ STRONE!!!
        System.out.println(hero);
    }
}
