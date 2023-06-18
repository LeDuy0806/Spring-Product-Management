package com.overpower.ProductManagementApi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "productstats")
public class ProductStat {
    private String productId;
    private int yearlySalesTotal;
    private int yearlyTotalSoldUnits;
    private List<MonthlyData> monthlyData;
    private List<DailyData> dailyData;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class MonthlyData {
    private String month;
    private int totalSales;
    private int totalUnits;
    private String id;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class DailyData {
    private String date;
    private int totalSales;
    private int totalUnits;
    private String id;
}


