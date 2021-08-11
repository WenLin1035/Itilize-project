package com.GroupProject.demo.controllertest;

import com.GroupProject.demo.Controller.UserController;
import com.GroupProject.demo.Entity.ColumnType;
import com.GroupProject.demo.Entity.Columns;
import com.GroupProject.demo.Repository.ColumnsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class usercontrollertest {
    @Autowired
    UserController userController;

    @Test
    public void saveTest(){
        System.out.println(userController.getallusers());
    }

    @Test
    public void getuserbyidTest(){
        System.out.println(userController.getuserbyid(8));
    }
}
