import java.util.Random;
class SavingAccount implements Account {
    String red = "\u001B[31m", green = "\u001B[32m", reset = "\u001B[0m", blue = "\u001B[34m", purple = "\u001B[35m";

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
        if (amount <= 0) {
            System.out.println(red + "Invalid withdrawal amount!");
            return;
        }
        if (this instanceof SavingAccount) {
            double maxWithdraw = balance * 0.8;
            if (amount > maxWithdraw) {
                double minRequired = balance * 0.2;
                System.out.println(red + "Cannot transfer $" + amount + ". At least $" + minRequired + " must remain in the account." + reset);
                return;
            }
        }
        if (amount > balance) {
            System.out.println(red + "Insufficient funds!" + red );
            return;
        }
        balance -= amount;
        System.out.println("Withdraw: $" + amount);
        System.out.println("Total balance: $" + balance);
        System.out.println(green + "Withdrawal successful");
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
        System.out.println("Account Type:" + green + "Saving Account" + reset);
        System.out.println("Account Number:" + green + accountNumber + reset);
        System.out.println("User Name:" + green + userName + reset);
        System.out.println("Date of Birth:" + green + dateOfBirth + reset);
        System.out.println("Gender:" + green + gander + reset);
        System.out.println("Phone Number" + green + phoneNumber + reset);
        System.out.println("Banlance:" + green + balance + reset);
        System.out.println("Interest Rate: " + (rate * 100) + "%");
    }
}
