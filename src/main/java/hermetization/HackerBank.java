package hermetization;

public class HackerBank extends GringotBank{
    @Override
    public String debit(int amount) {
        //nie możemy dostać się do pola balance, bo jest prywatne
        //możemy tylko zasymulować wypłatę
        super.debit(amount);
        return "Balance changed";
    }
}
