package com.GroupProject.demo.Repository;

import com.GroupProject.demo.Entity.Columns;
import com.GroupProject.demo.Entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ColumnsRepository extends JpaRepository<Columns, Integer> {
}
