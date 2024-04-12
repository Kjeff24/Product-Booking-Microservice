package com.bexos.productservice.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "product")
@Data
public class Product {
    @Id
    private String id;
    private String productName;
    private String productDescription;
    private Double perUnitPrice;
}
