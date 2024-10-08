package com.wakefit.ecommerce.serviceimplement;

import com.wakefit.ecommerce.entity.Feedback;
import com.wakefit.ecommerce.entity.Product;
import com.wakefit.ecommerce.entity.User;
import com.wakefit.ecommerce.exception.ResourceNotFoundException;
import com.wakefit.ecommerce.repository.FeedbackRepository;
import com.wakefit.ecommerce.repository.ProductRepository;
import com.wakefit.ecommerce.repository.UserRepository;
import com.wakefit.ecommerce.service.FeedbackService;
import com.wakefit.ecommerce.service.ProductService;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private UserRepository userRepository; // Assuming you have UserRepository injected

    @Autowired
    private ProductRepository productRepository; // Assuming you have ProductRepository injected

    
    @Override
    public Feedback addFeedback(Long userId, Long productId, Feedback feedback) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + productId));

        feedback.setUser(user);
        feedback.setProduct(product);

        // Perform any additional operations before saving feedback
        // feedback.setRating(feedback.getRating()); // Example

        return feedbackRepository.save(feedback);
    }


    @Override
    public Feedback getFeedbackById(Long feedbackId) {
        return feedbackRepository.findById(feedbackId)
                .orElseThrow(() -> new ResourceNotFoundException("Feedback not found with id " + feedbackId));
    }

    @Override
    @Transactional
    public Feedback updateFeedback(Long feedbackId, Feedback updatedFeedback) {
        Feedback existingFeedback = feedbackRepository.findById(feedbackId)
                .orElseThrow(() -> new ResourceNotFoundException("Feedback not found with id " + feedbackId));

        existingFeedback.setRating(updatedFeedback.getRating());
        existingFeedback.setComment(updatedFeedback.getComment());
        existingFeedback.setFeedbackDate(updatedFeedback.getFeedbackDate());

        return feedbackRepository.save(existingFeedback);
    }

    @Override
    public void deleteFeedback(Long feedbackId) {
        if (feedbackRepository.existsById(feedbackId)) {
            feedbackRepository.deleteById(feedbackId);
        } else {
            throw new ResourceNotFoundException("Feedback not found with id " + feedbackId);
        }
    }


	@Override
	public Feedback addFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		return feedbackRepository.save(feedback);
	}
}
