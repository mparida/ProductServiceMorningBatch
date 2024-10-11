package com.scaler.productservicemorningbatch.services;

import com.scaler.productservicemorningbatch.dtos.ProductDto;
import com.scaler.productservicemorningbatch.excepptions.InvalidProductIdException;
import com.scaler.productservicemorningbatch.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id) throws InvalidProductIdException;
    List<Product> getAllProducts();
    Product updateProduct();
    Product replaceProduct(Long id, ProductDto product);
    Product createProduct();
    void deleteProduct();
}


