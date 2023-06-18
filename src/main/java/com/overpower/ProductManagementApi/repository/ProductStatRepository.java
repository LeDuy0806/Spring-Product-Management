package com.overpower.ProductManagementApi.repository;

import com.overpower.ProductManagementApi.models.ProductStat;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductStatRepository extends MongoRepository<ProductStat, String> {
    Optional<ProductStat> findByProductId(String id);
}
