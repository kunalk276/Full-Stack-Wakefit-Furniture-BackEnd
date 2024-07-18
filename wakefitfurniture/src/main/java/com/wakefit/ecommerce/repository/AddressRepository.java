package com.wakefit.ecommerce.repository;

import com.wakefit.ecommerce.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface AddressRepository extends JpaRepository<Address, Long> {
    
}
