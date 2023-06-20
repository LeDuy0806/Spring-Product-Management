package com.overpower.ProductManagementApi.controller.temp;

import com.overpower.ProductManagementApi.models.ProductStat;
import com.overpower.ProductManagementApi.models.Products;
import com.overpower.ProductManagementApi.services.ProductService;
import com.overpower.ProductManagementApi.services.ProductStatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;
    private final ProductStatService productStatService;


    public ProductController(ProductService productService, ProductStatService productStatService) {
        this.productService = productService;
        this.productStatService = productStatService;
    }

    @GetMapping("")
    public List<Products> getAllProducts(){
        List<Products> listProducts = productService.getAllProducts();
        listProducts.forEach(product -> {
            product.setStat(productStatService.getProductStatByProductId(product.getId()));
        });
        return listProducts;
    }
    @GetMapping("/productstat/{id}")
    public ProductStat getProductStat(@PathVariable("id") String id){
        return productStatService.getProductStatByProductId(id);
    }
}
