package com.GroupProject.demo.Repositiry;

import com.GroupProject.demo.Entity.Columns;
import com.GroupProject.demo.Entity.Project;
import com.GroupProject.demo.Entity.Role;
import com.GroupProject.demo.Entity.User;
import com.GroupProject.demo.Repository.ColumnsRepository;
import com.GroupProject.demo.Repository.ProjectRepository;
import com.GroupProject.demo.Repository.UserRepository;
import com.GroupProject.demo.Service.ProjectService;
import com.GroupProject.demo.Service.UserService;
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

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    UserService userservices;

    @Autowired
    ProjectService projectService;

    @Test
    public void saveTest(){
        User col = new User();
        col.setUsername("brian");
        col.setPassword("12344456");
        col.setEmail("brian@gmail.com");
        col.setFirst_name("Brian");
        col.setLast_name("ki");
        col.setPhone(1266667);
        User test = userRepository.save(col);
        System.out.println(test);
    }

    @Test
    public void updatebyuseridTest(){
        User col = userservices.findbyid(8);
        Project pro = projectService.findbyid(4);
        System.out.println(pro.getUser_id());
    }
}
