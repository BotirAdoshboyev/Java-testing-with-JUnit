import exceptions.GeneralException;

public class BankAccount {

    private double balance = 0;
    private double minBalance;
    private boolean isActive;
    private String holderName;

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public BankAccount(String holderName) {
        this.isActive = true;
        this.minBalance = 10.0;
        this.holderName = holderName;
    }

    public BankAccount(String holderName, double balance) {
        this(holderName);
        this.balance = balance;
    }

    public BankAccount(String holderName, double balance, double minBalance) {
        this(holderName, balance);
        this.minBalance = minBalance;
    }

    public double withdraw(double amount) {
        if (balance - amount < minBalance) throw new GeneralException("Insufficient balance");
        balance -= amount;
        return balance;
    }

    public double deposit(double amount) {
        if (amount <= 0) throw new GeneralException("Negative amount not allowed");
        balance += amount;
        return balance;
    }
}
