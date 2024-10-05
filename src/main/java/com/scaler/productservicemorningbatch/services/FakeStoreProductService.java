package com.scaler.productservicemorningbatch.services;

import com.scaler.productservicemorningbatch.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class FakeStoreProductService implements ProductService {
    @Override
    public Product getProductById(Long id) {
        //Call Fake store api to get the product with given Id
        RestTemplate restTemplate = new RestTemplate();
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
