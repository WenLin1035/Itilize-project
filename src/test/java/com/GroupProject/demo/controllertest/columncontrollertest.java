package com.GroupProject.demo.controllertest;

import com.GroupProject.demo.Controller.ColumnController;
import com.GroupProject.demo.Controller.ProjectController;
import com.GroupProject.demo.Entity.ColumnType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class columncontrollertest {
    @Autowired
    ColumnController projectController;

    @Test
    public void saveTest(){
        projectController.createcolumn("controlcolumn1", ColumnType.TEXT);
        System.out.println(projectController.getallcolumns());
    }

    @Test
    public void getprojectbyidTest(){
        System.out.println(projectController.getcolumnbyid(7));
    }
}
