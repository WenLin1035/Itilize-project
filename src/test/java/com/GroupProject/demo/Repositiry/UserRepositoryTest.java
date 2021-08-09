package com.GroupProject.demo.Repositiry;

import com.GroupProject.demo.Entity.Columns;
import com.GroupProject.demo.Entity.Role;
import com.GroupProject.demo.Entity.User;
import com.GroupProject.demo.Repository.ColumnsRepository;
import com.GroupProject.demo.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Assert;
import org.junit.Before;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest{
    @Autowired
    UserRepository userRepository;

    @Test
    public void saveTest(){
        User col = new User();
        col.setUser_name("ma33on");
        col.setPassword("12344456");
        col.setEmail("masotttn@gmail.com");
        col.setFirst_name("maddson");
        col.setLast_name("oaan");
        col.setPhone(1266667);
        User test = userRepository.save(col);
        System.out.println(test);
    }
}
