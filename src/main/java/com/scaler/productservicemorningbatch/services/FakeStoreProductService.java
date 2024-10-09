package com.scaler.productservicemorningbatch.services;

import com.scaler.productservicemorningbatch.dtos.ProductDto;
import com.scaler.productservicemorningbatch.models.Category;
import com.scaler.productservicemorningbatch.models.Product;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class FakeStoreProductService implements ProductService {
    private  RestTemplate restTemplate;
    FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private Product convertFakeStoreProdyctDtoToProduct(ProductDto fdto){
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
        ProductDto FakeStoreProductResponseEntity = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, ProductDto.class);
        if (FakeStoreProductResponseEntity == null) {
            return null;
        }
        //Convert FakeStoreProductDto to Product
        return convertFakeStoreProdyctDtoToProduct(FakeStoreProductResponseEntity);
    }

    @Override
    public List<Product> getAllProducts() {
        ProductDto[] fakeStoreProductDtos = restTemplate.getForObject("https://fakestoreapi.com/products", ProductDto[].class);
        List<Product> products = new ArrayList<>();
        for(ProductDto fakeStoreProductDto : fakeStoreProductDtos){
            products.add(convertFakeStoreProdyctDtoToProduct(fakeStoreProductDto));
        }
        return products;
    }

    @Override
    public Product updateProduct() {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, ProductDto product) {
        //Put method
        //Replace the product with the given id with input product and return the updated product in the output
        //Put in RestTemplate is void, so we figured out how to use execute method from a sample Post method
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, ProductDto.class);
        HttpMessageConverterExtractor<ProductDto> responseExtractor = new HttpMessageConverterExtractor(ProductDto.class, restTemplate.getMessageConverters());
        ProductDto fakeStoreProductDto =  restTemplate.execute("https://fakestoreapi.com/products/" + id, HttpMethod.PUT, requestCallback, responseExtractor);
        return convertFakeStoreProdyctDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public Product createProduct() {
        return null;
    }

    @Override
    public void deleteProduct() {

    }
}
