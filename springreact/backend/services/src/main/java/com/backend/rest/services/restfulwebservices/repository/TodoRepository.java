package com.backend.rest.services.restfulwebservices.repository;

import com.backend.rest.services.restfulwebservices.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Long> {
}
