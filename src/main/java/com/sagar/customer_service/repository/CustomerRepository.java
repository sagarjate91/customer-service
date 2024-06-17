package com.sagar.customer_service.repository;

import com.sagar.customer_service.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

// select * from flipkart.customer_tb where first_name='A';
    Optional<Customer> findByFirstName(String firstName);

  //  select * from flipkart.customer_tb where last_name='B';
    Optional<Customer> findByLastName(String lastName);
}
