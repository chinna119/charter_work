package com.example.rewardApi.model;

import java.time.LocalDate;

/**
 * Represents a customer transaction with an amount and date.
 */
public class Transaction {

    private Long customerId;
    private Amount amount;
    private LocalDate date;

    public Transaction(Long customerId, Amount amount, LocalDate date) {
        this.customerId = customerId;
        this.amount = amount;
        this.date = date;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
