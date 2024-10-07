package com.scaler.productservicemorningbatch.services;

import com.scaler.productservicemorningbatch.dtos.FakeStoreProductDto;
import com.scaler.productservicemorningbatch.models.Category;
import com.scaler.productservicemorningbatch.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class FakeStoreProductService implements ProductService {
    private  RestTemplate restTemplate;
    FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private Product convertFakeStoreProdyctDtoToProduct(FakeStoreProductDto fdto){
        Product product = new Product();
        product.setId(fdto.getId());
        product.setDescription(fdto.getDescription());
        product.setTitle(fdto.getTitle());
        product.setImage(fdto.getImage());
        product.setPrice(fdto.getPrice());

        Category category = new Category();
        category.setTitle(fdto.getCategory());
        product.setCategory(category);
        return product;
    }
    @Override
    public Product getProductById(Long id) {
        //Call Fake store api to get the product with given Id
        FakeStoreProductDto FakeStoreProductResponseEntity = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
        if (FakeStoreProductResponseEntity == null) {
            return null;
        }
        //Convert FakeStoreProductDto to Product
        return convertFakeStoreProdyctDtoToProduct(FakeStoreProductResponseEntity);
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
