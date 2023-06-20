package com.overpower.ProductManagementApi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "affiliatestats")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AffiliateStat {
    @Id
    private String id;
    private ObjectId userId;
    private List<String> affiliateSales;
}
