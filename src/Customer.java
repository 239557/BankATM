public class Customer {
    private String name;
    private int pin;
    private Account savingsAccount;
    private Account checkingAccount;
    public Customer(String name, int pin) {
        this.name = name;
        this.pin = pin;
        this.savingsAccount = new Account("savings", 0.0, this);
        this.checkingAccount = new Account("checking", 0.0, this);
    }
    public String getName() {
        return name;
    }
    public int getPin() {
        return pin;
    }
    public void setPin(int newPin) {
        this.pin = newPin;
    }
    public Account getSavingsAccount() {
        return savingsAccount;
    }
    public Account getCheckingAccount() {
        return checkingAccount;
    }
}
