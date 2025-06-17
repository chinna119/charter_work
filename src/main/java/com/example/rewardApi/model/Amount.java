package com.example.rewardApi.model;

public class Amount {
    private int transactionAmount;
    private String currency;

    public Amount(int transactionAmount, String currency) {
        this.transactionAmount = transactionAmount;
        this.currency = currency;
    }

    public int getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(int transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
