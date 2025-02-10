import java.util.Random;
class SavingAccount implements Account {


    private int accountNumber;
    private String userName;
    private String dateOfBirth;
    private String gander;
    private String phoneNumber;
    private double balance;
    private double rate = 0.05;


    public SavingAccount( String userName, String dateOfBirth, String gander, String phoneNumber, double balance ){
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
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            targetAccount.deposit(amount);
            System.out.println("Transferred: $" + amount);
        } else {
            System.out.println("Transfer failed. Insufficient balance!");
        }
    }

    @Override
    public void displayAccountInfo() {
        System.out.println(">>>>>>>>>>>>>>>> Checking Account <<<<<<<<<<<<<<<<<");
        System.out.println("Account Type:" + "Saving Account");
        System.out.println("Account Number:" + accountNumber);
        System.out.println("User Name:" + userName);
        System.out.println("Date of Birth:" + dateOfBirth);
        System.out.println("Gender:" + gander);
        System.out.println("Phone Number" + phoneNumber);
        System.out.println("Banlance:" + balance);
        System.out.println("Interest Rate: " + (rate * 100) + "%");
    }
}
