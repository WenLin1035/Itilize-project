package com.GroupProject.demo.Entity;

import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;

/*
@author: Wen Lin
 */

@Entity
public class Date {
    @Id
    @GeneratedValue
    private Integer user_Id;
    private String joined;
    public Date(){

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
        LocalDate currentDate
                = LocalDate.now();
        this.joined = currentDate.getMonth() + "-" + currentDate.getYear();
    }
}
