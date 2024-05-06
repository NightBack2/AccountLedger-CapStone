package com.LearnToCode_Capstones;

import java.text.StringCharacterIterator;
import java.util.Date;

public class Bank {
    private Ledger ledger;

    public Bank() {
        this.ledger = new Ledger();
    }
    public void makeDeposit(Date date, double amount, String description, String vendor) {
        Transaction deposit = new Transaction(date, amount, description, vendor);

        ledger.addTransaction(deposit);
        System.out.println("Deposit of $" + amount + " made successfully.");
    }
    public Ledger getLedger(){
        return ledger;
    }
}
