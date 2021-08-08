package com.GroupProject.demo.Repositiry;

import com.GroupProject.demo.Entity.Columns;
import com.GroupProject.demo.Entity.Role;
import com.GroupProject.demo.Entity.User;
import com.GroupProject.demo.Repository.ColumnsRepository;
import com.GroupProject.demo.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Assert;
import org.junit.Before;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void saveTest(){
        User col = new User();
        col.setUser_name("jason");
        col.setPassword("123456");
        User test = userRepository.save(col);
        System.out.println(test.getUser_name());
    }
}
