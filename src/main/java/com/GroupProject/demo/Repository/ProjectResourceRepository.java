package com.GroupProject.demo.Repository;

import com.GroupProject.demo.Entity.ProjectResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/*
    @Author: Wen Lin
*/
@Repository
public interface ProjectResourceRepository  extends JpaRepository<ProjectResource, Integer> {
}
