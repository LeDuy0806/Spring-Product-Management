package com.overpower.ProductManagementApi.controller;

import com.overpower.ProductManagementApi.models.OverallStat;
import com.overpower.ProductManagementApi.repository.OverallStatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OverallStatController {
    @Autowired
    private final OverallStatRepository overallStatRepository;

    public OverallStatController(OverallStatRepository overallStatRepository) {
        this.overallStatRepository = overallStatRepository;
    }

    @GetMapping("/api/sales")
    public OverallStat getOverallStat(){
        return overallStatRepository.findAll().get(0);
    }

//    @GetMapping("/api/dashboard")
//    public OverallStat getDashboardStat(){
//        OverallStat overallStat =  overallStatRepository.findAll().get(0);
//    }
}
