import java.util.IllegalFormatWidthException;
import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Your name: ");
        String name = scanner.nextLine();
        System.out.println("Enter your ID number: ");
        int ID = scanner.nextInt();
        BankAcc bank = new BankAcc(name, ID);
        bank.showMenu();

    }
}

class BankAcc {
    int balance;
    int previousTransaction;
    String customerName;
    int customerId;
    BankAcc (String cname, int cid){
        customerId = cid;
        customerName = cname;
    }

    void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            previousTransaction = amount;
        }
    }
    void withdraw(int amount){
        if( amount > 0) {
            balance -= amount;
            previousTransaction = -amount;
        }
    }
    void getPreviousTransaction(){
        if (previousTransaction > 0)
            System.out.println("Deposited: " + previousTransaction);
        else if(previousTransaction < 0)
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        else System.out.println("No transaction occurred");
    }
    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is " + customerId);
        System.out.println("\n");
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous transaction");
        System.out.println("E. Exit");

        do {
            System.out.println("___________________________________________________________");
            System.out.println("Enter an option");
            System.out.println("___________________________________________________________");
            option = scanner.next().charAt(0);
            System.out.println("\n");
            switch (Character.toUpperCase(option)) {
                case 'A':
                    System.out.println("___________________________________________________________");
                    System.out.println("Balance = " + balance);
                    System.out.println("___________________________________________________________");
                    System.out.println("\n");
                    break;

                case 'B':
                    System.out.println("___________________________________________________________");
                    System.out.println("Enter an amount to deposit");
                    System.out.println("___________________________________________________________");
                    int depositAmount = scanner.nextInt();
                    deposit(depositAmount);
                    System.out.println("\n");
                    break;
                case 'C':
                    System.out.println("___________________________________________________________");
                    System.out.println("Enter an amount to withdraw");
                    System.out.println("___________________________________________________________");
                    int withdrawAmount = scanner.nextInt();
                    withdraw(withdrawAmount);
                    System.out.println("\n");
                    break;
                case 'D':
                    System.out.println("___________________________________________________________");
                    getPreviousTransaction();
                    System.out.println("___________________________________________________________");
                    System.out.println("\n");
                    break;
                case'E':
                    System.out.println("___________________________________________________________");
                    break;
                default:
                    System.out.println("Invalid Option! Please enter again");
                    break;
            }
        }
            while (Character.toUpperCase(option) != 'E') ;
            System.out.println("Thank you for using our services");
        }
    }


