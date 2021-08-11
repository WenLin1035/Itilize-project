package com.GroupProject.demo.Repository;

import com.GroupProject.demo.Entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Integer> {
}
