public class Account {
    private Customer currentUser;
    private double balance;
    private String accountName;
    public Account() {
        this.currentUser = currentUser;
        this.balance = balance;
        this.accountName = accountName;
    }
    public Customer getCurrentUser() {
        return currentUser;
    }
    public double getBalance() {
        return balance;
    }
    public String getAccountName() {
        return accountName;
    }
}