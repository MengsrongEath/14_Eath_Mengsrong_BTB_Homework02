import java.util.Scanner;
class CheckingAccount implements Account{

    private int accountNumber;
    private String userName;
    private String dateOfBirth;
    private String gander;
    private String phoneNumber;
    private double balance;

    public CheckingAccount(int accountNumber, String userName, String dateOfBirth, String gander, String phoneNumber, double balance){
        this.accountNumber = accountNumber;
        this.userName = userName;
        this.dateOfBirth = dateOfBirth;
        this.gander = gander;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
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
        System.out.println("Account Type:" + "Checking Account");
        System.out.println("Account Number:" + accountNumber);
        System.out.println("User Name:" + userName);
        System.out.println("Date of Birth:" + dateOfBirth);
        System.out.println("Gender:" + gander);
        System.out.println("Phone Number" + phoneNumber);
        System.out.println("Banlance:" + balance + "$");
    }
}
