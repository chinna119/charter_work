package com.example.rewardApi.service;

import com.example.rewardApi.exception.InvalidCustomerIdException;
import com.example.rewardApi.model.Amount;
import com.example.rewardApi.model.RewardSummary;
import com.example.rewardApi.model.Transaction;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.*;
import java.util.stream.Collectors;


/**
 * Business logic for calculating reward points.
 */
@Service
public class RewardService {

    private final List<Transaction> transactions = Arrays.asList(
            new Transaction(1L, new Amount(120,"USD"), LocalDate.now().minusMonths(1)),
            new Transaction(1L, new Amount(75,"USD"), LocalDate.now().minusMonths(2)),
            new Transaction(2L, new Amount(200,"USD"), LocalDate.now().minusMonths(1))
    );


    public List<RewardSummary> calculateRewards(Long customerId) {
        if (customerId != null && customerId < 0) {
            throw new InvalidCustomerIdException("Customer ID must be non-negative");
        }

        Map<Long, List<Transaction>> grouped = transactions.stream()
                .filter(t -> customerId == null || t.getCustomerId().equals(customerId))
                .collect(Collectors.groupingBy(Transaction::getCustomerId));

        List<RewardSummary> summaries = new ArrayList<>();

        for (Map.Entry<Long, List<Transaction>> entry : grouped.entrySet()) {
            Map<String, Integer> monthlyRewards = new HashMap<>();
            int total = 0;

            for (Transaction t : entry.getValue()) {
                int points = calculatePoints(t.getAmount());
                String month = t.getDate().getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
                monthlyRewards.put(month, monthlyRewards.getOrDefault(month, 0) + points);
                total += points;
            }

            summaries.add(new RewardSummary(entry.getKey(), monthlyRewards, total));
        }

        return summaries;
    }

    private int calculatePoints(Amount amount) {
        int points = 0;
        int transactionAmount =amount.getTransactionAmount();
        if (transactionAmount > 100) {
            points += 2 * (transactionAmount - 100) + 50;
        } else if (transactionAmount > 50) {
            points += transactionAmount - 50;
        }
        return points;
    }
}
