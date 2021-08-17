package com.GroupProject.demo.Repository;

import com.GroupProject.demo.Entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/*
    @Author: Wen Lin
*/
@Repository
public interface ResourceRepository  extends JpaRepository<Resource, Integer> {
}
