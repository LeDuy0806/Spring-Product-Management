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


