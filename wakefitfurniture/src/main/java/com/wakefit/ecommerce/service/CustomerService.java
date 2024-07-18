package com.wakefit.ecommerce.service;

import com.wakefit.ecommerce.entity.Customer;
import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer customer);
    Customer getCustomerById(Long customerId);
    List<Customer> getAllCustomers();
    void deleteCustomer(Long customerId);
	Customer updateCustomer(Long customerId, Customer updatedCustomer);
}
