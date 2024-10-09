package com.scaler.productservicemorningbatch.controllers;

import com.scaler.productservicemorningbatch.dtos.ProductDto;
import com.scaler.productservicemorningbatch.models.Product;
import com.scaler.productservicemorningbatch.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    ProductController (ProductService productService) {
        this.productService = productService;
    }
    //localhost:8080/products/10
    @GetMapping("/{id}")
    public ResponseEntity<Product> getPrductById(@PathVariable("id") Long id){
        Product product = productService.getProductById(id);
        return new ResponseEntity<Product>(product, HttpStatus.NOT_FOUND);
    }

    //localhost:8080/products
    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
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
    public Product replaceProduct(@PathVariable Long id, @RequestBody ProductDto product){
        return productService.replaceProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        return;
    }
}
