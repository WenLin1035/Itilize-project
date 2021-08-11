package com.GroupProject.demo.controllertest;

import com.GroupProject.demo.Controller.ProjectController;
import com.GroupProject.demo.Controller.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class projectcontrollertest {
    @Autowired
    ProjectController projectController;

    @Test
    public void saveTest(){
        projectController.createproject("controllertest1");
        System.out.println(projectController.getallprojects());
    }

    @Test
    public void getprojectbyidTest(){
        System.out.println(projectController.getprojectbyid(4));
    }
}
