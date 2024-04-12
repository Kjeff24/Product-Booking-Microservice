package com.bexos.productservice.repositories;

import com.bexos.productservice.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
