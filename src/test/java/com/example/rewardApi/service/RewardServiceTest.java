package com.example.rewardApi.service;

import com.example.rewardApi.exception.InvalidCustomerIdException;
import com.example.rewardApi.model.RewardSummary;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * Unit tests for reward calculation logic.
 */
public class RewardServiceTest {

    private final RewardService rewardService = new RewardService();

    @Test
    public void testValidCustomerRewards() {
        List<RewardSummary> summaries = rewardService.calculateRewards(1L);
        assertEquals(1, summaries.size());
    }

    @Test
    public void testInvalidCustomerIdThrowsException() {
        assertThrows(InvalidCustomerIdException.class, () -> rewardService.calculateRewards(-1L));
    }
}
