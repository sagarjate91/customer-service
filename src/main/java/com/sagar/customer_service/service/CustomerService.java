package com.sagar.customer_service.service;


import com.sagar.customer_service.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    String saveCustomers(Customer customer);

    Customer updateCustomer(Integer customerId);

    String deleteCustomer(Integer customerId);

    Customer getCustomerFirstName(String firstName);

    Customer getCustomerLastName(String lastName);
}
