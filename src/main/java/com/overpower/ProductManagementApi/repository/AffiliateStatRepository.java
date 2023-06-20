package com.overpower.ProductManagementApi.repository;

import com.overpower.ProductManagementApi.models.AffiliateStat;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface AffiliateStatRepository extends MongoRepository<AffiliateStat, String> {
    Optional<AffiliateStat> findByUserId(ObjectId id);
}
