package com.Ecommerce.ProductService.service;

import com.Ecommerce.ProductService.dto.ProductRequest;
import com.Ecommerce.ProductService.dto.ProductResponse;
import com.Ecommerce.ProductService.model.Product;
import com.Ecommerce.ProductService.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImple implements ProductService {
    @Autowired
    private final ProductRepository productRepository;
    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductResponse> productResponseList = new ArrayList<>();
        for (Product product : products) {
            ProductResponse productResponse = mapToProductResponse(product);
            productResponseList.add(productResponse);
        }
        return productResponseList;
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
