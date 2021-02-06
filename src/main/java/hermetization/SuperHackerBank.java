package hermetization;
//Klasa HermesBank nie zapewnia hermetyzacji bo można dostać się do pola balance
//i doprowadzić do ujemnej wartości
public class SuperHackerBank extends HermesBank{
    //Nadpisujemy metodę, aby doprowadzić do ujemnego stanu konta
    @Override
    public String debit(int amount) {
        balance -= amount;
        return "Yes";
    }
}
