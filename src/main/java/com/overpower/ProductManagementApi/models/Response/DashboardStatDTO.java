package com.overpower.ProductManagementApi.models.Response;

import com.overpower.ProductManagementApi.models.DailyData;
import com.overpower.ProductManagementApi.models.MonthlyData;
import com.overpower.ProductManagementApi.models.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DashboardStatDTO {
    private Integer totalCustomers;
    private Integer yearlySalesTotal;
    private Integer yearlyTotalSoldUnits;
    private List<MonthlyData> monthlyData;
    private List<DailyData> dailyData;
    private  MonthlyData thisMonthStats;
    private DailyData todayStats;

    private List<Transaction> transactions;
    private Map<String, Integer> salesByCategory;
}
