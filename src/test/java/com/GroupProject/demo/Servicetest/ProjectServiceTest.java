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
public class ProjectServiceTest {

    @Autowired
    ProjectService projectService;

    @Test
    public void saveTest(){
        Project project = new Project();
        project.setName("servicetest");
        projectService.saveproject(project);
    }

    @Test
    public void updatenameTest(){
        Project project = projectService.findbyid(4);
        project.setName("test2");
        projectService.updateprojectname(project);
    }

    @Test
    public void existTest(){
        Project project = projectService.findbyid(4);
        System.out.println(projectService.doesprojectexist(project));
    }
}
