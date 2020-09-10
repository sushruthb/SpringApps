package com.jumbo.repository;

import com.jumbo.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group,Long> {
    Group findByName(String name);
}
