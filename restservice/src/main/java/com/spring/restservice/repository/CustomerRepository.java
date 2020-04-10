package com.spring.restservice.repository;

import com.spring.restservice.model.Customer;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    List<Customer> findByLastName(String lastName);
    Customer findById(long id);
}
