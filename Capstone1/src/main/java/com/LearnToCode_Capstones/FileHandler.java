package com.LearnToCode_Capstones;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileHandler {

    public static void saveTransactionsToFile(List<Transaction> transactions, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Transaction transaction : transactions) {
                writer.println(transaction.toString());
            }
            System.out.println("Transactions saved to file: " + filePath);
        } catch (IOException e) {
            System.err.println("Error saving transactions to file: " + e.getMessage());
        }
    }
}