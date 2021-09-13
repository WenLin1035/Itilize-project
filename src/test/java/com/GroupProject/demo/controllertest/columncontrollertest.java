package com.GroupProject.demo.controllertest;

import com.GroupProject.demo.Controller.ColumnController;
import com.GroupProject.demo.Controller.ProjectController;
import com.GroupProject.demo.Entity.ColumnType;
import com.GroupProject.demo.Entity.Columns;
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
        projectController.createcolumn("controlcolumn1", ColumnType.TEXT, 1);
        System.out.println(projectController.getallcolumns());
    }

    @Test
    public void getprojectbyidTest(){
        projectController.updatecolumncontext(12,"controller test");
        System.out.println(projectController.getcolumnbyid(12));
    }
}
