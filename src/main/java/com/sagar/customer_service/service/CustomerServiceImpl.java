package com.sagar.customer_service.service;

import com.sagar.customer_service.exception.NoDataFoundException;
import com.sagar.customer_service.model.Customer;
import com.sagar.customer_service.model.ProductOrder;
import com.sagar.customer_service.repository.CustomerRepository;
import com.sagar.customer_service.repository.ProductOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{


    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductOrderRepository productOrderRepository;

    @Override
    public Customer getCustomerFirstName(String firstName)throws NoDataFoundException {
        Optional<Customer> customer= customerRepository.findByFirstName(firstName);
        if(customer.isPresent()){
            return customer.get();
        }else {
            throw new NoDataFoundException("Data is not found!");
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
    @Transactional(readOnly = true)
    public String saveCustomers(Customer customer) {
        customerRepository.save(customer);
        //customer.setCustomerId(null);
        productOrderRepository.save(ProductOrder.builder().customerId(customer.getCustomerId())
                .orderName("test1").build());
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
