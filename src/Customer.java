public class Customer {
    private String name;
    private int PIN;
    private Account savingsAccount;
    private Account checkingsAccount;
    public Customer(String name, int pin) {
        this.name = this.name;
        this.PIN = PIN;
    }
    public String getName() {
        return name;
    }
    public int getPIN() {
        return PIN;
    }
    public void setPIN(int setnewPIN) {
        this.PIN = setnewPIN;
    }
    public Account getcheckingsAccount() {
        return checkingsAccount;
    }
    public Account getsavingsAccount() {
        return savingsAccount;
    }
}