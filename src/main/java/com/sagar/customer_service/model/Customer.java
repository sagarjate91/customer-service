package com.sagar.customer_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;



@Entity
@Table(name = "Customer_TB")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {

    @Id
    @GeneratedValue
    @Column(name = "customer_id")
    private Integer id;
    private String firstName;
    private String lastName;
    @Column(name = "full_address")
    private String address;



}
