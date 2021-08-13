package com.GroupProject.demo.Servicetest;

import com.GroupProject.demo.Entity.Project;
import com.GroupProject.demo.Entity.Role;
import com.GroupProject.demo.Entity.User;
import com.GroupProject.demo.Service.ProjectService;
import com.GroupProject.demo.Service.UserService;
import com.GroupProject.demo.Service.impl.UserDetailServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {
    @Autowired
    UserService userservices;

    @Autowired
    ProjectService projectService;

    @Autowired
    UserDetailServiceImp userDetailService;

    @Test
    public void saveTest(){
        User col = new User();
        col.setUser_name("brian");
        col.setPassword("12344456");
        col.setEmail("brian@gmail.com");
        col.setFirst_name("Brian");
        col.setLast_name("ki");
        col.setPhone(1266667);
        col.setRole(Role.User);
        userservices.saveUser(col);
    }

    @Test
    public void updatebyuseridTest(){
        User col = userservices.findbyusername("brian");
        col.setRole(Role.User);
        userservices.saveUser(col);
    }

    @Test
    public void deletingTest(){
        //can't delete if user has a project
        User user = userservices.findbyid(8);
        userservices.deletebyuser(user);
    }

    @Test
    public void authenticatetest(){
        UserDetails test = userDetailService.loadUserByUsername("brian");
        System.out.println(test);
    }


}
