package com.GroupProject.demo.Repository;

import com.GroupProject.demo.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
