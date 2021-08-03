package practice;
import java.util.*;
public class Account {
    //Class Variables
    int balance, previousTransaction;
    String customerName, customerID;

    //Class constructor: first you name the class, and then
    // the variables you want to create inside.
    //This strings are going to show in the First Bank class.
    Account(String cname, String cid) {
        customerName = cname;
        customerID = cid;
    }
    //Function for depositing money
    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }
    //Function for withdrawing money
    void withdraw(int amount) {
        if (amount !=0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }
    //Function for showing your previous transaction
    void getPreviousTransaction() {
        if (previousTransaction > 0) //this means we deposited something
            { System.out.println("Deposited" + previousTransaction);
        } else if (previousTransaction < 0) //this means we didn't make a deposit
        {System.out.println("Withdrawn: " + Math.abs(previousTransaction));}
            else{
            System.out.println("No transaction occurred");}
    }
    //Function for calculating interest of funds after a number of years
    void calculateInterest(int years) {
        double interestRate = .015;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("The current interest rate is" + (100 * interestRate) + "%");
        System.out.println("After " + years + " years, your balance will be: " + newBalance);
    }
    //Function for showing the main menu: where all our options are going to be
    void showMenu() {
        char option = '\0'; //placeholder variable (we'll use it in a Switch later).
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");

        //We'll make a switch statement inside a do while loop
        do {
            System.out.println();
            System.out.println("Enter an option: ");
            //this means:
            char option1 = input.next().charAt(0);
            // 1. we're only going to take the FIRST character
            //of whatever the client writes
            option = Character.toUpperCase(option1);
            // 2. the client can write upper or lower case
            System.out.println();

            switch(option) {
                //Case A allows the user to check their account balance
                case 'A' :
                    System.out.println("--------------");
                    System.out.println("Balance = $" + balance);
                    System.out.println("--------------");
                    System.out.println();
                    break;
                // Case B allows the user to deposit money into their account
                case 'B' :
                    System.out.println("Enter the amount you want to deposit: ");
                    int amount = input.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;
                //Case C allows the user to withdraw money from their account
                case 'C':
                    System.out.println("Enter the amount you want to withdraw: ");
                    int amount2 = input.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;

                // Case D allow the user to view their most recent transaction
                case 'D':
                    System.out.println("-------------");
                    getPreviousTransaction();
                    System.out.println("-------------");
                    System.out.println();
                    break;

                // Case E calculates the interest on the account after a number of years
                case 'E':
                    System.out.println("Enter the number of years on interest: ");
                    int years = input.nextInt();
                    calculateInterest(years);
                    break;

                // Case F exits the user from their account
                case 'F':
                    System.out.println("-------------");
                    break;

                //Default: invalid character
                    default:
                    System.out.println("Error: invalid option. Please enter A, B, C, D, E or F.");
                    break;
            }
        } while(option != 'F');
        System.out.println("Thank you for banking with us! ");
    }
}
