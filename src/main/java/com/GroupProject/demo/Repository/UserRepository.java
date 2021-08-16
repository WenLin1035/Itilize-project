package com.GroupProject.demo.Repository;

import com.GroupProject.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    //@Query("select s from User s where s.username = :user_name")
    User findByUsername(/*@Param("user_name") */String username);
}
