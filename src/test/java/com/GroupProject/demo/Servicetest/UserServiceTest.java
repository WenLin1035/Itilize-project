package com.GroupProject.demo.Servicetest;

import com.GroupProject.demo.Entity.Project;
import com.GroupProject.demo.Entity.User;
import com.GroupProject.demo.Service.ProjectService;
import com.GroupProject.demo.Service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {
    @Autowired
    UserService userservices;

    @Autowired
    ProjectService projectService;

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
        User user = userservices.findbyid(1);
        userservices.deletebyuser(user);
    }
}
