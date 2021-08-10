package com.GroupProject.demo.Entity;

import com.GroupProject.demo.Entity.Enums.Roles;
import com.GroupProject.demo.Repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTest {

    @Autowired
    UserRepository userRepository;


    //Create User
    @Test
    public void createUserTest(){
        User user = new User();
        user.setUsername("username1");
        user.setPassword("password1");
        user.setFirstName("firstName1");
        user.setLastName("lastName1");
        user.setEmail("email1");
        user.setPhone(123456789);
        user.setTimeCreated(LocalDateTime.now());
        user.setTimeUpdated(LocalDateTime.now());

        User userTest = userRepository.save(user);
        System.out.println(userTest);

        Assert.assertNotNull(userTest);
        Assert.assertEquals(user, userTest);
    }

    //Read User
    @Test
    public void readUserByIdTest(){
        Integer userId = 2;

        boolean IsUserExists = userRepository.existsById(userId);

        Assert.assertTrue(IsUserExists);
    }

    //Update User
    @Test
    public void updateUserByIdTest(){
        Integer userId= 2;
        User expected = userRepository.getOne(userId);
        expected.setROLES(Roles.USER);
        expected.setTimeUpdated(LocalDateTime.now());

        User actual = userRepository.save(expected);

        Assert.assertEquals(Roles.USER, actual.getROLES());
    }

    //Delete User
    @Test
    public void deleteUserByIdTest(){
        Integer userId= 2;
        User expected = userRepository.getOne(userId);

        userRepository.deleteById(userId);

        boolean actual = userRepository.existsById(userId);

        Assert.assertFalse(actual);
    }

}