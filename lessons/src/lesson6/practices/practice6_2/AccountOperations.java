package lesson6.practices.practice6_2;

public interface AccountOperations {
    public double getBalance();
    public void deposit(double amount);
    public boolean withdraw(double amount);
    public String getDescription();
}
