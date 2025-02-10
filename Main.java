import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.Random;
public class Main {
    static CheckingAccount checkingAccount;
    static SavingAccount savingAccount;
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        String red = "\u001B[31m", green = "\u001B[32m", reset = "\u001B[0m", blue = "\u001B[34m", purple = "\u001B[35m";

        while (true){

            System.out.println("================== Online Banking System ==================");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. withdraw Money");
            System.out.println("4. Transfer Money");
            System.out.println("5. Display Account Information");
            System.out.println("6. Delete Account");
            System.out.println("7. Exit");
            System.out.println("-----------------------------------------");
            System.out.print("\n=> Choose option(1-7) :");

            int choose = sc.nextInt();
            switch(choose){
                case 1:
                    while (true){
                        System.out.println(">>>>>>>>>>>>>>>>>> Creatting Account <<<<<<<<<<<<<<<<<<<<");
                        System.out.println("1. Checking Account");
                        System.out.println("2. Saving Account");
                        System.out.println("3. Back");
                        System.out.println("===================================================");
                        System.out.print("\nWhat type of account do you want to create ?");
                        int option = sc.nextInt();
                        sc.nextLine();
                        if (option == 3) break;
                        switch (option) {
                            case 1:
                                System.out.println(">>>>>>>>>>>>>>>> Account Information <<<<<<<<<<<<<<<<");
                                System.out.print("Enter username:");
                                String userName = sc.nextLine();
                                System.out.print("Enter date of birth ( dd-mm-yyyy ):");
                                String dateOfBirth = sc.nextLine();
                                System.out.print("Enter gander:");
                                String gander = sc.nextLine();
                                System.out.print("Enter phone number:");
                                String phoneNumber = sc.nextLine();
                                if (option == 1) {
                                    checkingAccount = new CheckingAccount(userName, dateOfBirth, gander, phoneNumber, 0.0);
                                    System.out.println(green + "Your checking account has been created successfuly!" + reset);
                                    break;
                                }
                            case 2:
                                System.out.println(">>>>>>>>>>>>>>>> Account Information <<<<<<<<<<<<<<<<");
                                System.out.print("Enter username:");
                                String userName1 = sc.nextLine();
                                System.out.print("Enter date of birth ( dd-mm-yyyy ):");
                                String dateOfBirth1 = sc.nextLine();
                                System.out.print("Enter gander:");
                                String gander1 = sc.nextLine();
                                System.out.print("Enter phone number:");
                                String phoneNumber1 = sc.nextLine();

                                if (option == 2){
                                    savingAccount = new SavingAccount(userName1,dateOfBirth1,gander1,phoneNumber1,0.0);
                                    System.out.println(green + "Your saving account has been created successfuly!" + reset);
                                    break;
                                }
                        }
                    }
                    break;
                case 2:
                    while (true){
                        System.out.println(">>>>>>>>>>>>>>>>>> Deposit Money <<<<<<<<<<<<<<<<<<<<");
                        System.out.println("1. Checking Account");
                        System.out.println("2. Saving Account");
                        System.out.println("3. Back");
                        System.out.println("===================================================");
                        System.out.print("\nChoose an opption:");

                        int option = sc.nextInt();
                        sc.nextLine();
                        if (option == 3)
                            break;
                        switch (option){
                            case 1:
                                System.out.print("Enter money to deposit:");
                                double amount = sc.nextInt();
                                checkingAccount.deposit(amount);
                                System.out.println(" ".repeat(10)+"Checking Account"+" ".repeat(10));
                                System.out.println("\nResived:" + "$ " + amount);
                                System.out.println("==================================================");
                                System.out.println(green + "\nDeposit successful!" + reset );
                                break;
                            case 2:
                                System.out.print("Enter money to deposit:");
                                double amount1 = sc.nextInt();
                                savingAccount.deposit(amount1);
                                System.out.println(" ".repeat(10)+"Saving Account"+" ".repeat(10));
                                System.out.println("\nResived:" + "$ " + amount1);
                                System.out.println("Total:" + "$" + amount1);
                                System.out.println("==================================================");
                                System.out.println(green + "\nDeposit successful!" + reset );
                                break;
                        }
                    }
                    break;
                case 3:
                    while (true){
                        System.out.println(">>>>>>>>>>>>>>>>>> Withdraw Money <<<<<<<<<<<<<<<<<<<<");
                        System.out.println("1. Checking Account");
                        System.out.println("2. Saving Account");
                        System.out.println("3. Back");
                        System.out.println("===================================================");
                        System.out.print("Choose an opption:");
                        int option = sc.nextInt();
                        sc.nextLine();
                        if (option == 3)
                            break;
                        switch (option) {
                            case 1:
                                System.out.print("Enter money to withdraw:");
                                double amount1 = sc.nextInt();
                                checkingAccount.withdraw(amount1);
                                System.out.println(" ".repeat(10)+"Withdraw Account"+" ".repeat(10));
                                System.out.println("Withdraw:" + "$ " + amount1);
                                System.out.println("==================================================");
                                System.out.println(green + "\nWithdraw successful!" + reset );
                                break;
                            case 2:
                                System.out.print("Enter money to withdraw:");
                                double amount2 = sc.nextInt();
                                savingAccount.withdraw(amount2);
                                System.out.println(" ".repeat(10)+"Saving Account"+" ".repeat(10));
                                System.out.println("Withdraw:" + "$ " + amount2);
                                System.out.println("==================================================");
                                System.out.println(green + "\nWithdraw successful!" + reset );
                                break;
                        }
                    }
//                    break;
                case 4:
                    System.out.println("This is case 4");
                    break;

                case 5:
                    if (checkingAccount != null) checkingAccount.displayAccountInfo();
                    if (savingAccount != null) savingAccount.displayAccountInfo();
                    break;
                case 6:
                    System.out.println("Exiting the System...");
                    System.exit(0);
                    break;
                default:
                    System.out.println( red + "Invalid option! Try again." + reset);
            }

        }

    }

}
