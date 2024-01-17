import java.util.Scanner;
public class ATM {
    private Customer customer;
    private Account account;
    private TransactionHistory transactionHistory;
    private Scanner scanner;

    public ATM() {
        this.transactionHistory = new TransactionHistory();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        welcome();
    }

    private void welcome() {
        System.out.println(ConsoleUtility.BLUE + "Welcome to the Bank ATM" + ConsoleUtility.RESET);
        makeCustomer();
    }

    private void makeCustomer() {
        Scanner scan = new Scanner(System.in);
        System.out.print(ConsoleUtility.PURPLE + "Please enter your name: " + ConsoleUtility.RESET);
        String name = scan.nextLine();
        System.out.print(ConsoleUtility.RED + "Please enter your PIN: " + ConsoleUtility.RESET);
        int pin = scan.nextInt();
        scan.nextLine();
        System.out.println(ConsoleUtility.YELLOW + "Would you like to make a (C)heckings account or a (S)aving account" + ConsoleUtility.RESET);
        String answer = scan.nextLine();
        if (answer.equals("c")) {
            this.account = new Account("Checking Account", 0, customer);
        } else if (answer.equals("s")) {
            this.account = new Account("Savings Account", 0, customer);
        }
        System.out.println(ConsoleUtility.GREEN + "Account created" + ConsoleUtility.RESET);
        mainMenu();
    }

    private void mainMenu() {
        boolean continueTransaction = true;
        while (continueTransaction) {
            System.out.println("Main Menu:");
            System.out.println(ConsoleUtility.RED + "1." + ConsoleUtility.RESET + " Withdraw money");
            System.out.println(ConsoleUtility.YELLOW + "2." + ConsoleUtility.RESET + " Deposit money");
            System.out.println(ConsoleUtility.YELLOW + "3." + ConsoleUtility.RESET + " Transfer money between accounts");
            System.out.println(ConsoleUtility.GREEN + "4." + " Get account balances");
            System.out.println(ConsoleUtility.BLUE + "5." + ConsoleUtility.RESET + " Get transaction history");
            System.out.println(ConsoleUtility.PURPLE + "6." + ConsoleUtility.RESET + " Change PIN");
            System.out.println(ConsoleUtility.PURPLE + "7." + ConsoleUtility.RESET + " Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
        }
    }
}