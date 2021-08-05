package com.GroupProject.demo.Entity;

import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;

/*
@author: Wen Lin
 */

@Entity
@Table(name="date")
public class Date {
    @Id
    @GeneratedValue
    @Column(name="user_id")
    private Integer user_Id;
    @Column(name="joined")
    private String joined;
    public Date(){}
    public Date(Integer id){
        user_Id = id;
        LocalDate currentDate
                = LocalDate.now();
        joined = currentDate.getMonth() + "-" + currentDate.getYear();
    }
    public Integer getUser_Id(){
        return user_Id;
    }
    public void setUser_Id(Integer id){
        user_Id = id;
    }
    public String getJoined(){
        return joined;
    }
    public  void setJoined(){
        LocalDate currentDate = LocalDate.now();
        joined = currentDate.getMonth() + "-" + currentDate.getYear();
    }
    @Override
    public String toString(){
        return "Member since\n" + joined;
    }
}
