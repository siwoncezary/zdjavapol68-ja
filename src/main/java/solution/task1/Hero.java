package solution.task1;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Hero extends Person{
    public Hero(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    @Override
    public String toString() {
        return "Bohater "+ name + " urodzony w " + birthDate.format(DateTimeFormatter.ofPattern("dd-MM-YYYY"));
    }
}
