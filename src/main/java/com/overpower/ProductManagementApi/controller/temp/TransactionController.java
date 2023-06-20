package com.overpower.ProductManagementApi.controller.temp;

import com.overpower.ProductManagementApi.models.Response.TransactionPage;

import com.overpower.ProductManagementApi.services.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

//    @GetMapping("/transactions")
//    public TransactionPage getTransactions(
//            @RequestParam(defaultValue = "1") int page,
//            @RequestParam(defaultValue = "20") int pageSize,
//            @RequestParam(required = false, defaultValue = "") String sort,
//            @RequestParam(defaultValue = "") String search
//    ) {
//        return transactionService.getTransactionPagination(page,pageSize,sort,search);
//    }
}
