package com.scaler.productservicemorningbatch.controllers;

import com.scaler.productservicemorningbatch.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    ProductController(ProductService productService) {
        this.productService = productService;
    }
    //localhost:8080/products/10
    @GetMapping("/{}")
    public Product getPrductById(@PathVariable("id") Long id){
        return new Product();
    }

    //localhost:8080/products
    @GetMapping()
    public List<Product> getAllProducts(){
        return new ArrayList<Product>();
    }

    //Create Product
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return new Product();
    }
    //partial update
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product){
        return new Product();
    }

    //Replace a product
    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable Long id, @RequestBody Product product){
        return new Product();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        return;
    }
}
