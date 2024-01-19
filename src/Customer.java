public class Customer {
    private String name;
    private int customerPin;
    private Account savingsAccount;
    private Account checkingsAccount;
    public Customer(String name, int Pin) {
        this.name = this.name;
        this.customerPin = Pin;
    }
    public String getName() {
        return name;
    }
    public int getPIN() {
        return customerPin;
    }
    public void setPIN(int setnewPIN) {
        this.customerPin = setnewPIN;
    }
    public Account getcheckingsAccount() {
        return checkingsAccount;
    }
    public Account getsavingsAccount() {
        return savingsAccount;
    }
}