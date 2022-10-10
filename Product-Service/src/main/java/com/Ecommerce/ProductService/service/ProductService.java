package com.Ecommerce.ProductService.service;

import com.Ecommerce.ProductService.dto.ProductRequest;
import com.Ecommerce.ProductService.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    void createProduct(ProductRequest productRequest);
    List<ProductResponse> getAllProducts();
}
