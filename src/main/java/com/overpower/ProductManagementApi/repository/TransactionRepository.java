package com.overpower.ProductManagementApi.repository;

import com.overpower.ProductManagementApi.models.Transaction;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {
    List<Transaction> findByIdIn(List<String> affiliateSales);
//    List<Transaction> find(Query query);
}
