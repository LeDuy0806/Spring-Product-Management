package com.overpower.ProductManagementApi.controller;

import com.overpower.ProductManagementApi.models.ProductStat;
import com.overpower.ProductManagementApi.models.Products;
import com.overpower.ProductManagementApi.models.Response.TransactionPage;
import com.overpower.ProductManagementApi.services.ProductService;
import com.overpower.ProductManagementApi.services.ProductStatService;
import com.overpower.ProductManagementApi.services.TransactionService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    private final ProductService productService;
    private final ProductStatService productStatService;
    private final TransactionService transactionService;
    @Autowired
    MongoTemplate mongoTemplate;



    public ClientController(ProductService productService, ProductStatService productStatService, TransactionService transactionService) {
        this.productService = productService;
        this.productStatService = productStatService;
        this.transactionService = transactionService;
    }

    @GetMapping("/products")
    public List<Products> getAllProducts(){
        List<Products> listProducts = productService.getAllProducts();
        listProducts.forEach(product -> {
            product.setStat(productStatService.getProductStatByProductId(product.getId()));
        });
        return listProducts;
    }
    @GetMapping("/transactions")
    public TransactionPage getTransactions(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int pageSize,
            @RequestParam(required = false, defaultValue = "") String sort,
            @RequestParam(defaultValue = "") String search
    ) {
        return transactionService.getTransactionPagination(page,pageSize,sort,search);
    }
    @GetMapping("/geography")
    public List<GeographyDTO> getGeography() {
        GroupOperation groupOperation = Aggregation.group("country").count().as("count");
        Aggregation aggregation = Aggregation.newAggregation(groupOperation);

        List<Map> result = mongoTemplate.aggregate(aggregation, "users", Map.class).getMappedResults();
//        System.out.println(result);
        List<GeographyDTO> formattedLocations = result.stream()
                .map(map -> new GeographyDTO((String) map.get("_id"), (int) map.get("count")))
                .collect(Collectors.toList());

        return formattedLocations;
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class GeographyDTO{
    private String id;
    private int value;
}
