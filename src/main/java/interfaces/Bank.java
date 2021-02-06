package interfaces;

public interface Bank {
    String credit(int amount);
    String debit(int amount);
    int balance();
}
