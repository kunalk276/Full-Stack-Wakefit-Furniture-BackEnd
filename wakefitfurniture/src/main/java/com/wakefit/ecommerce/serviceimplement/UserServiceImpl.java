package com.wakefit.ecommerce.serviceimplement;
import com.wakefit.ecommerce.entity.*;
import com.wakefit.ecommerce.exception.ResourceNotFoundException;
import com.wakefit.ecommerce.repository.UserRepository;
import com.wakefit.ecommerce.service.ProductService;
import com.wakefit.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductService productService;

    @Override
    public User saveUser(User user) {
        if (user.getCart() != null) {
            saveCart(user.getCart());
        }
        if (user.getOrders() != null) {
            for (Order order : user.getOrders()) {
                saveOrder(order);
            }
        }
        if (user.getAddresses() != null) {
            for (Address address : user.getAddresses()) {
                saveAddress(address);
            }
        }
        if (user.getFeedbacks() != null) {
            for (Feedback feedback : user.getFeedbacks()) {
                saveFeedback(feedback);
            }
        }
        return userRepository.save(user);
    }

    private void saveCart(Cart cart) {
        // Implement cart save logic
    }

    private void saveOrder(Order order) {
        if (order.getCart() != null) {
            saveCart(order.getCart());
        }
        if (order.getProducts() != null) {
            for (Product product : order.getProducts()) {
                productService.addProduct(product);
            }
        }
    }

    private void saveAddress(Address address) {
        // Implement address save logic
    }

    private void saveFeedback(Feedback feedback) {
        Product product = feedback.getProduct();
        if (product != null && product.getProductId() == null) {
            product = productService.addProduct(product);
        }
        feedback.setProduct(product);
    }

    @Override
    public User updateUser(Long userId, User user) {
        Optional<User> existingUserOptional = userRepository.findById(userId);
        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            existingUser.setUserName(user.getUserName());
            existingUser.setPassword(user.getPassword());
            existingUser.setEmail(user.getEmail());
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setMobNo(user.getMobNo());
            existingUser.setRole(user.getRole());

            return userRepository.save(existingUser);
        } else {
            throw new ResourceNotFoundException("User not found with id " + userId);
        }
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public User getUserByUserName(String userName) {
        User user = userRepository.findByUserName(userName);
        if (user == null) {
            throw new ResourceNotFoundException("User not found with username " + userName);
        }
        return user;
    }

    @Override
    public void deleteUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found with id " + userId);
        }
        userRepository.deleteById(userId);
    }
}
