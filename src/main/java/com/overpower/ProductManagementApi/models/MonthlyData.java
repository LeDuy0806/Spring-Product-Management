package com.overpower.ProductManagementApi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public
class MonthlyData {
//    @Id
//    private String id;
    private String month;
    private int totalSales;
    private int totalUnits;


}
