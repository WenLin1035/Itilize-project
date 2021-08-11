package com.GroupProject.demo.Repository;

import com.GroupProject.demo.Entity.Columns;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColumnRepository extends JpaRepository<Columns, Integer> {
}
