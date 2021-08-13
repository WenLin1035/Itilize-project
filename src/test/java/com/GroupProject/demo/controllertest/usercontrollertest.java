package com.GroupProject.demo.controllertest;

import com.GroupProject.demo.Controller.UserController;
import com.GroupProject.demo.Entity.ColumnType;
import com.GroupProject.demo.Entity.Columns;
import com.GroupProject.demo.Entity.Role;
import com.GroupProject.demo.Entity.User;
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



    @org.junit.jupiter.api.Test
    public void registertest(){
        User col = new User();
        col.setUser_name("dan");
        col.setPassword("12344456");
        col.setEmail("dan@gmail.com");
        col.setFirst_name("dan");
        col.setLast_name("gg");
        col.setPhone(1266633);
        col.setRole(Role.User);
        userController.register(col);
    }
}
