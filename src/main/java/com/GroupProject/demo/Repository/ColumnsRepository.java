package com.GroupProject.demo.Repository;

import com.GroupProject.demo.Entity.Columns;
import com.GroupProject.demo.Entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColumnsRepository extends JpaRepository<Columns, Integer> {
}
