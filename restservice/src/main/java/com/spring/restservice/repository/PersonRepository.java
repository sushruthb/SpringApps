package com.spring.restservice.repository;

import com.spring.restservice.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
@RepositoryRestResource(collectionResourceRel = "customer", path = "customer")
public interface PersonRepository extends PagingAndSortingRepository<Customer, Long> {
    List<Customer> findByLastName(@Param("firstname") String name);
}
