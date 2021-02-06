package hermetization;

public class HermesBank extends Bank{
    protected int balance;
    @Override
    public String credit(int amount) {
        if(amount < 0){
            return "No";
        }
        balance += amount;
        return "Yes";
    }

    @Override
    public String debit(int amount) {
        if (amount < 0 || balance < 0){
            return "No";
        }
        balance -= amount;
        return "Yes";
    }

    @Override
    public int balance() {
        return balance;
    }
}
