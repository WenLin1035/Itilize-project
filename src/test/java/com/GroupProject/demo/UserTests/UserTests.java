package com.GroupProject.demo.UserTests;

import com.GroupProject.demo.Entity.User;
import com.GroupProject.demo.Repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTests {

    private UserRepository userRepository;
    private User user;

    @Before
    public void setup(){
        user = new User();
    }

    @Test
    public void createUserTest(){
        String username = "user0";
        String password = "passwd0";
        String firstName = "first0";
        String lastName = "last0";
        String email = "email0";
        int phone = 123456789;
        user = new User(username, password,firstName, lastName, email, phone);

        user = userRepository.save(user);

        Integer expectedUserId = user.getUserId();

        Assert.assertNotNull(expectedUserId);

    }




}
