package com.wakefit.ecommerce.service;

import java.util.List;

import com.wakefit.ecommerce.entity.Product;

public interface ProductService {

    Product addProduct(Product product);

    Product getProductById(Long productId);

    Product updateProduct(Product product);

    void deleteProduct(Long productId);

	List<Product> getAllProducts();

	
    
}


