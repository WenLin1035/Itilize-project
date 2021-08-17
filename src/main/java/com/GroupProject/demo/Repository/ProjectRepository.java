package com.GroupProject.demo.Repository;

import com.GroupProject.demo.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/*
    @Author: Wen Lin
*/
@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
