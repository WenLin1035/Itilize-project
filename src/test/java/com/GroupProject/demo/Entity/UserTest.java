package com.GroupProject.demo.Entity;

import com.GroupProject.demo.Repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTest {

    @Autowired
    UserRepository userRepository;


    @Test
    public void createUserTest(){
        // Stemail = "email0"ring username = "user0";
        //   String password = "passwd0";
        //   String firstName = "first0";
        //  String lastName = "last0";
        //   String email = "email0";
        //   int phone = 123456789;
        User user = new User();
        user.setUsername("user3");
        user.setPassword("passwd0");
        user.setFirstName("first0");
        user.setLastName("lastName");
        user.setEmail("email0");
        user.setPhone(123456789);

        User userTest1 = userRepository.save(user);
        System.out.println(userTest1);



        Assert.assertNotNull(userTest1);

    }

}