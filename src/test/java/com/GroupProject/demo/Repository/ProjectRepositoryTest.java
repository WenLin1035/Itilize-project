package com.GroupProject.demo.Repository;

import com.GroupProject.demo.Entity.Project;
import com.GroupProject.demo.Entity.Resource;
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

        //Existing user
        Integer userId = 1;
        User user = userRepository.getOne(userId);

        //Create new project
        Project project = new Project();
        project.setProjectName("Project 1");
        project.setUser(user);
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

    //Update project
    @Test
    public void updateProjectByIdTest(){
        Integer projectId= 1;
        Project expected = projectRepository.getOne(projectId);
        expected.setProjectName("Project1");
        expected.setTimeUpdated(LocalDateTime.now());

        Project actual = projectRepository.save(expected);

        Assert.assertEquals("Project1", actual.getProjectName());
    }

    //Delete Project
    @Test
    public void deleteProjectByIdTest(){

        Integer projectId= 1;

        projectRepository.deleteById(projectId);

        boolean actual = projectRepository.existsById(projectId);

        Assert.assertFalse(actual);
    }

}