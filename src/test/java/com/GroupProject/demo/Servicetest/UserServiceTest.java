package com.GroupProject.demo.Servicetest;

import com.GroupProject.demo.Entity.Project;
import com.GroupProject.demo.Entity.User;
import com.GroupProject.demo.Service.ProjectService;
import com.GroupProject.demo.Service.UserDetailService;
import com.GroupProject.demo.Service.UserService;
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
    UserDetailService userDetailService;

    @Test
    public void saveTest(){
        User col = new User();
        col.setUser_name("brian");
        col.setPassword("12344456");
        col.setEmail("brian@gmail.com");
        col.setFirst_name("Brian");
        col.setLast_name("ki");
        col.setPhone(1266667);
        userservices.saveUser(col);
    }

    @Test
    public void updatebyuseridTest(){
        User col = userservices.findbyid(8);
        Project pro = projectService.findbyid(4);
        col.addproject(pro);
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
        UserDetails test = userDetailService.loadUserByUsername("mason");
        System.out.println(test);
    }
}
