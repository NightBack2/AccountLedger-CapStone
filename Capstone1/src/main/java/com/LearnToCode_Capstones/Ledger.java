package com.LearnToCode_Capstones;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ledger {
    private List<Transaction> transactions;

    public Ledger() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        // Sort the list so the newest entries come first
        Collections.sort(transactions, Comparator.comparing(Transaction::getDate).reversed());
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }


}
