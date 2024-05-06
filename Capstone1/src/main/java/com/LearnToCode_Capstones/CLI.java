// CLI class
package com.LearnToCode_Capstones;

import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.List;

public class CLI {
    private Ledger ledger;
    private Scanner scanner;

    public CLI() {
        ledger = new Ledger();
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("Home Screen");
            System.out.println("Welcome To AccountLedger Application!");
            System.out.println("1) Save to File");
            System.out.println("2) Make Payment");
            System.out.println("3) Make Deposit");
            System.out.println("4) Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline left by nextInt()

            switch (option) {
                case 1:
                    saveToFile();
                    break;
                case 2:
                    makePayment();
                    break;
                case 3:
                    makeDeposit();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    private void makePayment() {
        System.out.print("Enter the payment date (YYYY-MM-DD): ");
        String dateString = scanner.nextLine();
        System.out.print("Enter the payment amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline left by nextDouble()
        System.out.print("Enter the payment description: ");
        String description = scanner.nextLine();
        System.out.print("Enter the vendor name: ");
        String vendor = scanner.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter the date in the format YYYY-MM-DD.");
            return;
        }
        Transaction transaction = new Transaction(date, amount, description, vendor);
        ledger.addTransaction(transaction);
        System.out.println("Payment added successfully.");
    }

    private void makeDeposit() {
        System.out.print("Enter the deposit date (YYYY-MM-DD): ");
        String dateString = scanner.nextLine();
        System.out.print("Enter the deposit amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline left by nextDouble()
        System.out.print("Enter the deposit description: ");
        String description = scanner.nextLine();
        System.out.print("Enter the vendor name: ");
        String vendor = scanner.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter the date in the format YYYY-MM-DD.");
            return;
        }
        Transaction transaction = new Transaction(date, amount, description, vendor);
        ledger.addTransaction(transaction);
        System.out.println("Deposit added successfully.");
    }

    private void saveToFile() {
        System.out.print("Enter the file path to save transactions: ");
        String filePath = scanner.nextLine();
        FileHandler.saveTransactionsToFile(ledger.getTransactions(), filePath);
    }
}
