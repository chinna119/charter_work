package com.example.rewardApi.controller;

import com.example.rewardApi.model.RewardSummary;
import com.example.rewardApi.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for exposing reward calculation endpoints.
 */

@RestController
@RequestMapping("api/rewards")
public class RewardController {

    @Autowired
    private RewardService rewardService;

    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @GetMapping
    public List<RewardSummary> getRewards(@RequestParam(required = false) Long customerId) {
        return rewardService.calculateRewards(customerId);
    }

}
