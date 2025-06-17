package com.example.rewardApi.model;

import java.util.Map;

/**
 * DTO to hold reward points summary per customer.
 */
public class RewardSummary {


    private Long customerId;
    private Map<String, Integer> monthlyRewards;
    private int totalRewards;

    public RewardSummary(Long customerId, Map<String, Integer> monthlyRewards, int totalRewards) {
        this.customerId = customerId;
        this.monthlyRewards = monthlyRewards;
        this.totalRewards = totalRewards;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Map<String, Integer> getMonthlyRewards() {
        return monthlyRewards;
    }

    public void setMonthlyRewards(Map<String, Integer> monthlyRewards) {
        this.monthlyRewards = monthlyRewards;
    }

    public int getTotalRewards() {
        return totalRewards;
    }

    public void setTotalRewards(int totalRewards) {
        this.totalRewards = totalRewards;
    }
}
