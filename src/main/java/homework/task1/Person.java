package homework.task1;

import java.time.LocalDate;

class Person{
    final String name;
    final LocalDate birthDate;

    public Person(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Osoba " + name + " urodzona w " + birthDate;
    }
}
