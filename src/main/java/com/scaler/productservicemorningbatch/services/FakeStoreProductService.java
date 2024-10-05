package com.scaler.productservicemorningbatch.services;

import com.scaler.productservicemorningbatch.models.Product;

import java.util.List;

public class FakeStoreProductService implements ProductService {
    @Override
    public Product getProductById(Long id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product updateProduct() {
        return null;
    }

    @Override
    public Product replaceProduct() {
        return null;
    }

    @Override
    public Product createProduct() {
        return null;
    }

    @Override
    public void deleteProduct() {

    }
}
