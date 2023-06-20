package com.overpower.ProductManagementApi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document(collection = "overallstats")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OverallStat {
    @Id
    private String id;
    private Integer yearlySalesTotal;
    private Integer yearlyTotalSoldUnits;
    private Integer year;
    private List<MonthlyData> monthlyData;
    private List<DailyData> dailyData;
    private Map<String, Integer> salesByCategory;

}
