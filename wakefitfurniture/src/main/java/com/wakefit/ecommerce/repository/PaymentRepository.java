package com.wakefit.ecommerce.repository;

import com.wakefit.ecommerce.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PaymentRepository extends JpaRepository<Payment, Long> {
   
}
