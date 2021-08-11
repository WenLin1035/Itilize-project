package com.GroupProject.demo.controllertest;

import com.GroupProject.demo.Controller.ProjectController;
import com.GroupProject.demo.Controller.ProjectResourceController;
import com.GroupProject.demo.Controller.ResourceController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class projectresourcecontrollertest {
    @Autowired
    ProjectResourceController projectController;

    @Autowired
    ProjectController pcontroller;

    @Autowired
    ResourceController rcontroller;



    @Test
    public void saveTest(){
        projectController.createprojectresource(pcontroller.getprojectbyid(11), rcontroller.getresourcebyid(6));
    }

    @Test
    public void getprojectbyidTest(){
        System.out.println(projectController.getprojectbyid(4));
    }
}
