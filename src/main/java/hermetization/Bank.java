package hermetization;

abstract public class Bank {
    public abstract String credit(int amount);
    public abstract String debit(int amount);
    public abstract int balance();
}
