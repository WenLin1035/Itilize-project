package com.GroupProject.demo.Entity;

import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.math.BigDecimal;

/*
@author: Wen Lin
 */

@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String password;
    private String name;
    public User(){

    }
    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String pass){
        this.password = pass;
    }
    public String name(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
