package com.wakefit.ecommerce.repository;

import com.wakefit.ecommerce.entity.Cart;
import com.wakefit.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ProductRepository extends JpaRepository<Product, Long> {

	static void save(Cart cart) {
		// TODO Auto-generated method stub
		
	}
   
}
