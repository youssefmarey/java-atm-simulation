package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int pin = 1234;
        int i = 0;
        double balance = 2500.75;
        boolean isLoggedIn = false;
        int option;
        int depositCount = 0;
        int withdrawCount = 0;

        while (i < 3) {
            System.out.print("Enter The PIN : ");
            int currentPin = scanner.nextInt();
            if (pin == currentPin) {
                System.out.println("Login Successful!");
                isLoggedIn = true;
                break;
            }
            i++;

        }
        if (isLoggedIn) {

            do {
                if (balance == 0) {
                    System.out.println("Warning: Your account is empty");
                }
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Show Account Status");
                System.out.println("5. Exit");
                System.out.print("Select option : ");
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("Your current balance is: " + balance);
                        break;
                    case 2:
                        System.out.println("Enter The Deposit");
                        double deposit = scanner.nextDouble();
                        if (deposit <= 0) {
                            System.out.println("Amount must be greater than zero!");
                        } else {
                            balance += deposit;
                            System.out.println("Deposit successful! Your balance is: " + balance);
                            depositCount++;
                        }
                        break;
                    case 3:
                        System.out.println("Enter The Withdraw");
                        double withdraw = scanner.nextDouble();
                        if (withdraw == 0) {
                            System.out.println("Insufficient balance");
                        } else if (withdraw < 0) {
                            System.out.println("Transaction cancelled");
                        } else if (withdraw > balance) {
                            System.out.println("Invalid amount");
                        } else {
                            balance -= withdraw;
                            System.out.println("Withdrawal successful! Your balance is: " + balance);
                            withdrawCount++;
                        }
                        break;
                    case 4:
                        if (balance >= 5000) {
                            System.out.println("VIP Customer");
                        } else if (balance >= 1000) {
                            System.out.println("Regular Customer");
                        } else {
                            System.out.println("Low Balance");
                        }
                        break;
                    case 5:
                        System.out.println("Total Successful Deposit Transactions: " + depositCount);
                        System.out.println("Total Successful Withdrawal Transactions: " + withdrawCount);
                        System.out.println("Thank you for using our ATM");
                        break;
                    default:
                        System.out.println("Invalid option");
                }

            } while (option != 5);
        } else {
            System.out.println("Your account has been locked");
        }


    }
}
