package com.GroupProject.demo.Repository;

import com.GroupProject.demo.Entity.Enums.Roles;
import com.GroupProject.demo.Entity.Project;
import com.GroupProject.demo.Entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProjectRepositoryTest {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProjectRepository projectRepository;

    //Create Project
    @Test
    public void createProjectTest(){

        //Create new user
        /*In case database gets cleared, creation of new user to avoid
        /*referencing non-existing user.
        /*Tests should be independent of each other.*/
        User user = new User();
        user.setUsername("username2");
        user.setPassword("password2");
        user.setFirstName("firstName2");
        user.setLastName("lastName2");
        user.setEmail("email2");
        user.setPhone("12345678910");
        user.setTimeCreated(LocalDateTime.now());
        user.setTimeUpdated(LocalDateTime.now());

        User userTest = userRepository.save(user);

        boolean IsUserExists = userRepository.existsById(userTest.getUserId());

        Assert.assertNotNull(userTest);
        Assert.assertTrue(IsUserExists);
        Assert.assertEquals(user, userTest);

        //Create new project
        Project project = new Project();
        project.setProjectName("Project 1");
        project.setUser(userTest);
        project.setTimeCreated(LocalDateTime.now());
        project.setTimeUpdated(LocalDateTime.now());

        Project projectTest = projectRepository.save(project);

        boolean IsProjectExists = projectRepository.existsById(project.getProjectId());

        Assert.assertNotNull(projectTest);
        Assert.assertTrue(IsProjectExists);
        Assert.assertEquals(project, projectTest);
    }

    //Read Project
    @Test
    public void readProjectByIdTest(){
        Integer projectId = 1;

        boolean IsProjectExists = projectRepository.existsById(projectId);

        Assert.assertTrue(IsProjectExists);
    }

    //Update User
    @Test
    public void updateUserByIdTest(){
        Integer userId= 3;
        User expected = userRepository.getOne(userId);
        expected.setROLES(Roles.USER);
        expected.setTimeUpdated(LocalDateTime.now());

        User actual = userRepository.save(expected);

        Assert.assertEquals(Roles.USER, actual.getROLES());
    }

    //Delete User
    @Test
    public void deleteUserByIdTest(){
        Integer userId= 3;
        User expected = userRepository.getOne(userId);

        userRepository.deleteById(userId);

        boolean actual = userRepository.existsById(userId);

        Assert.assertFalse(actual);
    }

}