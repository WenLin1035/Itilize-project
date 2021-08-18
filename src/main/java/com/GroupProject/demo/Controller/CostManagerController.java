package com.GroupProject.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*
    @Author: Wen Lin
*/
@RestController
@RequestMapping("/CostManager")
public class CostManagerController {


    @GetMapping("/hello")
    public String sayhello(){
        return "hello";
    }

}
