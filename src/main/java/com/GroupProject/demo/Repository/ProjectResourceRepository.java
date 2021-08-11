package com.GroupProject.demo.Repository;

import com.GroupProject.demo.Entity.Project;
import com.GroupProject.demo.Entity.ProjectResources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectResourceRepository extends JpaRepository<ProjectResources, Integer> {
}
