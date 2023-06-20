package com.overpower.ProductManagementApi.repository;

import com.overpower.ProductManagementApi.models.OverallStat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface OverallStatRepository extends MongoRepository<OverallStat, String> {
}
