package com.overpower.ProductManagementApi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {
    @Id
    private String id;
    private String name;
    private Double price;
    private String description;
    private String category;
    private Double rating;
    private Integer supply;
    @DBRef
    private ProductStat stat;
}
