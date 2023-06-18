package com.overpower.ProductManagementApi.services;

import com.overpower.ProductManagementApi.models.ProductStat;
import com.overpower.ProductManagementApi.repository.ProductStatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductStatService {

    @Autowired
    ProductStatRepository productStatRepository;

    public ProductStat getProductStatById(String id){
        ProductStat result = productStatRepository.findById(id).orElse(null);
        if(result != null) {
            return result;
        }
        else
            return null;
    }
    public ProductStat getProductStatByProductId(String id){
        ProductStat result = productStatRepository.findByProductId(id).orElse(null);
        if(result != null) {
            return result;
        }
        else
            return null;
    }
}
