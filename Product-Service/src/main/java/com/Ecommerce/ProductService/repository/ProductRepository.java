package com.Ecommerce.ProductService.repository;

import com.Ecommerce.ProductService.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
