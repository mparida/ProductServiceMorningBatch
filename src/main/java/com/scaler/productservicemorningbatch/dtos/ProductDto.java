package com.scaler.productservicemorningbatch.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private Long Id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
}
