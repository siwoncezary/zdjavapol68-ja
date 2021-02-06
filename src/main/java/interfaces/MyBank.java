package interfaces;

import java.io.Serializable;

public class MyBank implements Bank, Serializable, Printable {
    private int balance;
    @Override
    public String credit(int amount) {
        if (amount < 0){
            return "No change. Invalid amount.";
        }
        balance += amount;
        return "Account changed";
    }

    @Override
    public String debit(int amount) {
        if (amount < 0){
            return "No change. Invalid amount.";
        }
        if (balance - amount < 0){
            return "No change. No enough balance.";
        }
        balance -= amount;
        return "Account changed";
    }

    @Override
    public int balance() {
        return balance;
    }

    @Override
    public String print(String device) {
        System.out.println("Printing using device: " + device);
        return "Posumowanie konta: " + balance + "pln";
    }
}
