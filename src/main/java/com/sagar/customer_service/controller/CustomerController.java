package com.sagar.customer_service.controller;


import com.sagar.customer_service.exception.NoDataFoundException;
import com.sagar.customer_service.model.Customer;
import com.sagar.customer_service.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/getCustomers")
    public List<Customer> getCustomers(){
      return customerService.getCustomers();
    }

    @GetMapping("/getCustomers/firstName/{firstName}")
    public ResponseEntity<Customer> getCustomersFirstName(@PathVariable String firstName) throws NoDataFoundException {
        return ResponseEntity.ok(customerService.getCustomerFirstName(firstName));
    }

    @GetMapping("/getCustomers/lastName/{lastName}")
    public Customer getCustomersLastName(@PathVariable String lastName){
        return customerService.getCustomerLastName(lastName);
    }

    @PostMapping("/save")
    public String saveCustomer(@RequestBody Customer customer){
       return customerService.saveCustomers(customer);
    }
}
