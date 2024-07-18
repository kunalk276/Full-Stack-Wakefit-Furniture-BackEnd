package com.wakefit.ecommerce.repository;

import com.wakefit.ecommerce.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
   
}
