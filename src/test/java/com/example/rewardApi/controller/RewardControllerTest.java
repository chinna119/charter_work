package com.example.rewardApi.controller;

import com.example.rewardApi.RewardApiApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Integration tests for reward API endpoints.
 */
@SpringBootTest(classes = RewardApiApplication.class)
@AutoConfigureMockMvc
public class RewardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllRewards() throws Exception {
        mockMvc.perform(get("/api/rewards"))
                .andExpect(status().isOk());
    }
}
