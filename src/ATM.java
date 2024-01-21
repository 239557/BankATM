import java.util.Scanner;
public class ATM {
    private Customer customer;
    private TransactionHistory transactionHistory;
    private Scanner scanner;

    public ATM() {
        this.transactionHistory = new TransactionHistory();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        welcome();
        makeCustomer();
        if (verifyPin()) {
            while (true) {
                if (!mainMenu()) {
                    break;
                }
            }
            // Exiting the program
            exit();
        }
    }
    private void welcome() {
        System.out.println(ConsoleUtility.BLUE + "Welcome to the Bank ATM" + ConsoleUtility.RESET);
    }

    private void makeCustomer()  {
            System.out.println(ConsoleUtility.PURPLE + "Please enter your name:" + ConsoleUtility.RESET);
            String name = scanner.nextLine();
            System.out.println(ConsoleUtility.RED + "Choose a 4-digit PIN:" + ConsoleUtility.RESET);
            int pin = scanner.nextInt();
            scanner.nextLine(); // consume newline
            this.customer = new Customer(name, pin);
            System.out.println(ConsoleUtility.CYAN + "Account created successfully!" + ConsoleUtility.RESET);
        }
    private boolean verifyPin() {
        System.out.println(ConsoleUtility.RED + "Please re-enter your PIN:" + ConsoleUtility.RESET);
        int inputPin = scanner.nextInt();
        scanner.nextLine(); // consume newline
        if (inputPin == customer.getPin()) {
            return true;
        } else {
            System.out.println("Incorrect PIN. Please try again.");
            return false;
        }
    }

    private boolean mainMenu() {
        System.out.println(ConsoleUtility.GREEN + "Main Menu:" + ConsoleUtility.RESET);
        System.out.println(ConsoleUtility.RED + "1. Withdraw Money" + ConsoleUtility.RESET);
        System.out.println(ConsoleUtility.BLUE + "2. Deposit Money" + ConsoleUtility.RESET);
        System.out.println(ConsoleUtility.PURPLE + "3. Transfer Money" + ConsoleUtility.RESET);
        System.out.println(ConsoleUtility.CYAN + "4. Check Balance" + ConsoleUtility.RESET);
        System.out.println(ConsoleUtility.YELLOW + "5. Change PIN" + ConsoleUtility.RESET);
        System.out.println(ConsoleUtility.WHITE + "6. Exit" + ConsoleUtility.RESET);
        System.out.print(ConsoleUtility.WHITE + "Please choose an option: " + ConsoleUtility.RESET);
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            withdrawMoney();
        } else if (choice == 2) {
            depositMoney();
        } else if (choice == 3) {
            transferMoney();
        } else if (choice == 4) {
            checkBalances();
        } else if (choice == 5) {
            changePin();
        } else if (choice == 6) {
            return false; //refers to the customerWantsToStay boolean and returns false since they want to leave
        } else {
            System.out.println("Invalid option. Please try again.");
        }

        return true;
    }
    //Methods
    private void withdrawMoney() {
        System.out.print(ConsoleUtility.RED + "Enter amount to withdraw: " + ConsoleUtility.RESET);
        double amount = scanner.nextDouble();
        scanner.nextLine();
        if (amount % 5 != 0 || amount <= 0) {
            System.out.println(ConsoleUtility.RED + "Invalid amount. Please enter a positive multiple of 5." + ConsoleUtility.RESET);
            return;
        }
        // Calculate the number of $20 and $5 bills
        int twenties = (int) (amount / 20);
        int fives = (int) ((amount % 20) / 5);

        if (customer.getCheckingAccount().withdraw(amount)) {
            System.out.println(ConsoleUtility.RED + "Withdrawal successful. Dispensing bills: " + twenties + " $20 bills, " + fives + " $5 bills." + ConsoleUtility.RESET);
            System.out.println("New balance: " + customer.getCheckingAccount().getBalance());
            transactionHistory.addTransaction("Withdrawal: " + amount);
        } else if (customer.getSavingsAccount().withdraw(amount)) {
            System.out.println(ConsoleUtility.RED + "Withdrawal successful. Dispensing bills: " + twenties + " $20 bills, " + fives + " $5 bills." + ConsoleUtility.RESET);
            System.out.println("New balance: " + customer.getSavingsAccount().getBalance());
            transactionHistory.addTransaction("Withdrawal: " + amount);
        } else {
            System.out.println(ConsoleUtility.RED + "Insufficient funds or invalid amount." + ConsoleUtility.RESET);
        }
    }

    private void depositMoney() {
        System.out.print(ConsoleUtility.BLUE + "Enter amount to deposit: " + ConsoleUtility.RESET);
        double amount = scanner.nextDouble();
        scanner.nextLine();
        // Calculate the number of $20 and $5 bills
        int twenties = (int) (amount / 20);
        int fives = (int) ((amount % 20) / 5);
        customer.getCheckingAccount().deposit(amount);
        System.out.println(ConsoleUtility.BLUE + "Deposit successful. Accepting bills: " + twenties + " $20 bills, " + fives + " $5 bills." + ConsoleUtility.RESET);
        System.out.println("New balance: " + customer.getCheckingAccount().getBalance());
        transactionHistory.addTransaction("Deposit: " + amount);
    }

    private void transferMoney() {
        System.out.print(ConsoleUtility.PURPLE + "Enter amount to transfer: " + ConsoleUtility.RESET);
        double amount = scanner.nextDouble();
        scanner.nextLine();
        // transfer from checking to savings
        if (customer.getCheckingAccount().withdraw(amount)) {
            customer.getSavingsAccount().deposit(amount);
            System.out.println(ConsoleUtility.PURPLE + "Transfer successful." + ConsoleUtility.RESET);
            transactionHistory.addTransaction("Transfer: " + amount);
        } else {
            System.out.println(ConsoleUtility.RED + "Insufficient funds or invalid amount." + ConsoleUtility.RESET);
        }
    }

    private void checkBalances() {
        System.out.println(ConsoleUtility.CYAN + "Checking account balance: " + ConsoleUtility.RESET + customer.getCheckingAccount().getBalance());
        System.out.println(ConsoleUtility.CYAN + "Savings account balance: " + ConsoleUtility.RESET + customer.getSavingsAccount().getBalance());
        transactionHistory.addTransaction("Checked balances");
    }

    private void changePin() {
        System.out.print(ConsoleUtility.YELLOW + "Enter new 4-digit PIN: " + ConsoleUtility.RESET);
        int newPin = scanner.nextInt();
        scanner.nextLine();
        customer.setPin(newPin);
        System.out.println(ConsoleUtility.YELLOW + "PIN changed successfully." + ConsoleUtility.RESET);
        transactionHistory.addTransaction("PIN change");
    }
    public void exit() {
        System.out.println(ConsoleUtility.PURPLE + "Thank you for using our Bank ATM. Have a great day!" + ConsoleUtility.RESET);
    }
}