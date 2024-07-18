package com.wakefit.ecommerce.service;

import com.wakefit.ecommerce.entity.*;

import java.util.List;

public interface AdminService {
    // Admin
    Admin createAdmin(Admin admin);
    Admin updateAdmin(Long adminId, Admin admin);
    void deleteAdmin(Long adminId);
    Admin getAdminById(Long adminId);
    

    // Product
    Product createProduct(Product product);
    Product updateProduct(Long productId, Product product);
    void deleteProduct(Long productId);
    Product getProductById(Long productId);
    List<Product> getAllProducts();

    // Category
    Category createCategory(Category category);
    Category updateCategory(Long categoryId, Category category);
    void deleteCategory(Long categoryId);
    Category getCategoryById(Long categoryId);
    List<Category> getAllCategories();

    // Order
    Order updateOrder(Long orderId, Order order);
    void deleteOrder(Long orderId);
    Order getOrderById(Long orderId);

    // Cart
    void deleteCart(Long cartId);
    Cart getCartById(Long cartId);

    // Address
    Address createAddress(Address address);
    Address updateAddress(Long addressId, Address address);
    void deleteAddress(Long addressId);
    Address getAddressById(Long addressId);

    // Feedback
    Feedback updateFeedback(Long feedbackId, Feedback feedback);
    void deleteFeedback(Long feedbackId);
    Feedback getFeedbackById(Long feedbackId);
    List<Feedback> getAllFeedbacks();

    // Payment
    Payment getPaymentById(Long paymentId);
	
	
	
}
