import java.util.Scanner;
public class ATM {
    private static Scanner scan;
    private static Customer customer;
    private Account account;

    public ATM() {
        scan = new Scanner(System.in);
    }

    public static void start() {
        welcome();
    }

    private static void welcome() {
        System.out.println(ConsoleUtility.BLUE + "Welcome to the Bank ATM" + ConsoleUtility.RESET);
        System.out.print("Please enter your name: ");
        String name = scan.nextLine();
        System.out.print("Please enter your PIN: ");
        int pin = scan.nextInt();
        scan.nextLine();
        customer = new Customer(name, pin);
    }

    private void accountName() {
        account = new Account();
    }

}