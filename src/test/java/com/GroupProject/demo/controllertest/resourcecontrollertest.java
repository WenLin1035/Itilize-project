package com.GroupProject.demo.controllertest;

import com.GroupProject.demo.Controller.ProjectController;
import com.GroupProject.demo.Controller.ResourceController;
import com.GroupProject.demo.Entity.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class resourcecontrollertest {
    @Autowired
    ResourceController projectController;

    @Test
    public void saveTest(){
        projectController.createresource("controltest2",00022);
        System.out.println(projectController.getallresource());
    }

    @Test
    public void getprojectbyidTest(){
        System.out.println(projectController.getresourcebyid(10));
    }
}
