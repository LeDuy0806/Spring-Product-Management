package com.overpower.ProductManagementApi.repository;

import com.overpower.ProductManagementApi.models.Products;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductsRepository extends MongoRepository<Products, String> {
}
