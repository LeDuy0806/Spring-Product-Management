package com.overpower.ProductManagementApi.models.Response;

import com.overpower.ProductManagementApi.models.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionPage{
    private List<Transaction> transactions;
    private long total;
}