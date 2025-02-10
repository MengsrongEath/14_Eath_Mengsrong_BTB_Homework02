import java.util.Scanner;
import java.util.Random;
class CheckingAccount implements Account{
    String red = "\u001B[31m", green = "\u001B[32m", reset = "\u001B[0m", blue = "\u001B[34m", purple = "\u001B[35m";
    private int accountNumber;
    private String userName;
    private String dateOfBirth;
    private String gander;
    private String phoneNumber;
    private double balance;

    public CheckingAccount(String userName, String dateOfBirth, String gander, String phoneNumber, double balance){
        this.accountNumber = generateAccountNumber();
        this.userName = userName;
        this.dateOfBirth = dateOfBirth;
        this.gander = gander;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }
    private int generateAccountNumber() {
        Random random = new Random();
        return 100000000 + random.nextInt(900000000);
    }

    Scanner sc = new Scanner(System.in);

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount!");
        }
    }
    @Override
    public void transfer(double amount, Account targetAccount) {


    }

    @Override
    public void displayAccountInfo() {
        System.out.println(">>>>>>>>>>>>>>>> Checking Account <<<<<<<<<<<<<<<<<");
        System.out.println("Account Type:" + green + "Checking Account" + reset);
        System.out.println("Account Number:" + green +  generateAccountNumber() + reset );
        System.out.println("User Name:" + green + userName + reset);
        System.out.println("Date of Birth:" + green + dateOfBirth + reset);
        System.out.println("Gender:" + green + gander + reset);
        System.out.println("Phone Number" + green + phoneNumber + reset);
        System.out.println("Banlance:" + green + balance + "$" + reset);
    }
}
