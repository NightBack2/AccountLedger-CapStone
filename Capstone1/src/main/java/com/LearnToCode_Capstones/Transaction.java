package com.LearnToCode_Capstones;
import java.util.Date;

public class Transaction {
    private Date date;
    private double amount;
    private String description;
    private String vendor;

    public Transaction(Date date, double amount, String description, String vendor) {
        this.date = date;
        this.amount = amount;
        this.description = description;
        this.vendor = vendor;
    }

    // Getters and setters for each field
    public Date getDate() {
        return date;
    }

    // Other getters and setters...


    @Override
    public String toString() {
        return "Date: " + date + ", Amount: " + amount + ", Description: " + description + ", Vendor: " + vendor;
    }
}
