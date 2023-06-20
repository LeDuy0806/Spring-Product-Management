package com.overpower.ProductManagementApi.services;


import com.overpower.ProductManagementApi.models.Transaction;
import com.overpower.ProductManagementApi.models.Response.TransactionPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    MongoTemplate mongoTemplate;

    public TransactionPage getTransactionPagination(int page , int pageSize, String sort, String search){
        Query query = new Query();

        if (!search.isEmpty()) {
            Criteria criteria = new Criteria().orOperator(
                    Criteria.where("cost").regex(search, "i"),
                    Criteria.where("userId").regex(search, "i")
            );
            query.addCriteria(criteria);
        }


        if (sort != null && !sort.equals("{}") && !sort.equals("")) {
//            System.out.println(sort);
            Sort.Direction direction = sort.endsWith("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
            String field = sort.substring(0, sort.length() - 3);
            query.with(Sort.by(direction, field));
        }

        long total = mongoTemplate.count(query, Transaction.class);

        query.with(PageRequest.of(page - 1, pageSize));
        List<Transaction> transactions = mongoTemplate.find(query, Transaction.class);

        return new TransactionPage(transactions, total);
    }
}

