package com.sagar.customer_service.service;

import com.sagar.customer_service.model.Customer;
import com.sagar.customer_service.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{


    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer getCustomerFirstName(String firstName) {
        Optional<Customer> customer= customerRepository.findByFirstName(firstName);
        if(customer.isPresent()){
            return customer.get();
        }else {
            throw new RuntimeException("Data is not found!");
        }

    }

    @Override
    public Customer getCustomerLastName(String lastName) {
        return customerRepository.findByLastName(lastName).get();
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public String saveCustomers(Customer customer) {
        customerRepository.save(customer);
        return "Customer deatils is added!";
    }

    @Override
    public Customer updateCustomer(Integer customerId) {
        return null;
    }

    @Override
    public String deleteCustomer(Integer customerId) {
        return "";
    }
}
