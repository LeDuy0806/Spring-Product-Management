package com.overpower.ProductManagementApi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public
class DailyData {
//    @Id
//    private String id;
    private String date;
    private int totalSales;
    private int totalUnits;
}
