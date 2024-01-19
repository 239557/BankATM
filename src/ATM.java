import java.util.Scanner;
public class ATM {
    private Customer customer;
    private int customerPin;
    private String customerName;
    private int end;
    private Scanner scan;

    public ATM() {
        scan = new Scanner(System.in);
        end = 0;
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
        System.out.print(ConsoleUtility.PURPLE + "Before we begin please enter your name: " + ConsoleUtility.RESET);
        String name = scan.nextLine();
        customerName = name;
        System.out.print(ConsoleUtility.BLUE + "Create a new pin for your account: " + ConsoleUtility.RESET);
        customerPin = scan.nextInt();
        customer = new Customer(customerName, customerPin);
        System.out.println(ConsoleUtility.RED + "Reenter the pin of your new account please: " + ConsoleUtility.RESET);
        int repeat = -1;
        while (repeat == -1) {
            System.out.println(ConsoleUtility.BLUE + "Enter your pin: " + ConsoleUtility.RESET);
            int pin = scan.nextInt();
            if (pin == customerPin) {
                repeat = 0;
            } else {
                System.out.println(ConsoleUtility.RED + "Wrong pin. Please try again: " + ConsoleUtility.RESET);
                System.out.println("");
            }
        }
        mainMenu();
    }

    private void mainMenu() {
        System.out.println(ConsoleUtility.BLUE + "Welcome to the ATM" + ConsoleUtility.RESET);
        System.out.println(ConsoleUtility.RED + "1." + " Withdraw money" + ConsoleUtility.RESET);
        System.out.println(ConsoleUtility.YELLOW + "2." + " Deposit money" + ConsoleUtility.RESET);
        System.out.println(ConsoleUtility.YELLOW + "3." + " Transfer money between accounts" + ConsoleUtility.RESET);
        System.out.println(ConsoleUtility.GREEN + "4." + " Get account balances" + ConsoleUtility.RESET);
        System.out.println(ConsoleUtility.BLUE + "5." + " Get transaction history" + ConsoleUtility.RESET);
        System.out.println(ConsoleUtility.PURPLE + "6." + " Change PIN" + ConsoleUtility.RESET);
        System.out.println(ConsoleUtility.PURPLE + "7." + " Exit" + ConsoleUtility.RESET);
        int option = 9;
        while (option > 7) {
            System.out.print(ConsoleUtility.CYAN + "Enter a valid number please: " + ConsoleUtility.RESET);
            option = scan.nextInt();
            scan.nextInt();
            if (option > 7) {
                System.out.println(ConsoleUtility.RED + "Number is not valid. Please try again: " + ConsoleUtility.RESET);
            }
        }
        if (option == 1) {
            customer.withDraw();
            reEnterPin();
        }
        if (option == 2) {
            customer.Deposit();
            reEnterPin();
        }

        if (option == 3) {
            customer.transferMoney();
            reEnterPin();
        }
        if (option == 4) {
            System.out.println(customer.getBalances);
        }
        if (option == 5) {
            System.out.println(customer.getTransactionHistory);
            reEnterPin;
        }
        if (option == 6) {
            changePin();
            System.out.println(customer.getSReceipt("Changed Pin!"));
            reEnterPin;
        }
        if (option == 7) {
            System.out.println(ConsoleUtility.BLUE + "Thank you for using the ATM and have a great day" + ConsoleUtility.RESET);
        }
    }
    public void reEnterPin() {
        System.out.println("Would you like to do anything more (Y/N): ");
        String more = scan.next();
        if (more.equals("Y")) {
            int repeat = 0;
            while (repeat == 0) {
                System.out.println("Re-enter your pin please: ");
                int check = scan.nextInt();
                if (check == customerPin) {
                    repeat = 1;
                    mainMenu();
                } else {
                    System.out.println("Invalid Pin");
                }
            }
        } else {
            System.out.println("Thank you for using the ATM and have a great day!");
        }
    }
    public void changePin() {
        System.out.println("What would you like to change your pin to: ");
        int newPin = scan.nextInt();
        setCustomerPin(newPin);
    }
}
