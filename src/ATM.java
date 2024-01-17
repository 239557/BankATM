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
        System.out.print(ConsoleUtility.RED + "Please enter your PIN (only 4 numbers and no spaces please): " + ConsoleUtility.RESET);
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
            System.out.println(ConsoleUtility.WHITE + "Please select an option: " + ConsoleUtility.RESET);
            System.out.println(ConsoleUtility.RED + "(1)" + " Withdraw money" + ConsoleUtility.RESET);
            System.out.println(ConsoleUtility.YELLOW + "(2)" + " Deposit money" + ConsoleUtility.RESET);
            System.out.println(ConsoleUtility.YELLOW + "(3)" + " Transfer money between accounts" + ConsoleUtility.RESET);
            System.out.println(ConsoleUtility.GREEN + "(4)" + " Get account balances" + ConsoleUtility.RESET);
            System.out.println(ConsoleUtility.BLUE + "(5)" + " Get transaction history" + ConsoleUtility.RESET);
            System.out.println(ConsoleUtility.PURPLE + "(6)" + " Change PIN" + ConsoleUtility.RESET);
            System.out.println(ConsoleUtility.PURPLE + "(7)" + " Exit" + ConsoleUtility.RESET);
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            withDraw(choice);
        }
    }

    private void withDraw(int choice) {
        Scanner scan = new Scanner(System.in);
        if (choice == 1) {
            System.out.println(ConsoleUtility.RED + "How much money would you like to withdraw and from which account?" + ConsoleUtility.RESET);
            int withDraw = scan.nextInt();
            deposit(choice);
        }
    }

    private void deposit(int choice) {
        Scanner scan = new Scanner(System.in);
        if (choice == 2) {
            System.out.println(ConsoleUtility.CYAN + "How much money would you like to deposit and from which account?" + ConsoleUtility.RESET);
            int deposit = scan.nextInt();
            transfer(choice);
        }
    }
    private void transfer(int choice) {
        Scanner scan = new Scanner(System.in);
        if (choice == 3) {
            System.out.println(ConsoleUtility.GREEN + "How much would you like to transfer?" + ConsoleUtility.RESET);
            accountBalances(choice);
        }
    }
    private void accountBalances(int choice) {
        Scanner scan = new Scanner(System.in);
        if (choice == 4) {
            System.out.println(ConsoleUtility.PURPLE + "");
            transactionHistory(choice);
        }
    }
    private void transactionHistory(int choice) {
        Scanner scan = new Scanner(System.in);
        if (choice == 5) {
            System.out.println(ConsoleUtility.BLUE + "");
            changePIN(choice);
        }
    }
    private void changePIN(int choice) {
        Scanner scan = new Scanner(System.in);
        if (choice == 6) {
            System.out.println(ConsoleUtility.RED + "");
            exit(choice);
        }
    }
    private void exit(int choice) {
        Scanner scan = new Scanner(System.in);
        if (choice == 7) {
            System.out.println(ConsoleUtility.RED + "");
        }
    }
}