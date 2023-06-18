package com.overpower.ProductManagementApi.services;

import com.overpower.ProductManagementApi.models.ProductStat;
import com.overpower.ProductManagementApi.models.Products;
import com.overpower.ProductManagementApi.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductsRepository productsRepository;

    public List<Products> getAllProducts(){
        return productsRepository.findAll();
    }
}
