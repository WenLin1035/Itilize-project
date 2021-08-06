package com.GroupProject.demo.Entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
@author: Wen Lin
 */

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    private Integer user_id;

    @Column(name="user_name",unique = true,nullable = false)
    private String user_name;

    @Column(name="password",nullable = false)
    private String password;

    @Column(name="first_name")
    private String first_name;

    @Column(name="last_name")
    private String last_name;

    @Column(name="email_address",unique = true,nullable = false)
    private String email;

    @Column(name="phone")
    private Integer phone;

    @CreatedDate
    @Column(name="timeCreated")
    private LocalDate timecreated;

    @LastModifiedDate
    @Column(name="timeUpdated")
    private LocalDate timeupdated;

    @Enumerated(EnumType.STRING)
    @Column(name="role")
    private Role role;

    @Column(name="project_id")
    private Integer project_id;

    @OneToMany(targetEntity = Project.class, cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private List<Project> projectCollection;

    public User(String user, String pass, String fname, String lname, String email, Integer phone,Role role, Integer pid){
        user_name = user;
        password = pass;
        first_name = fname;
        last_name = lname;
        this.email = email;
        this.phone = phone;
        this.timecreated = LocalDate.now();
        this.timeupdated = LocalDate.now();
        this.role = role;
        this.project_id = pid;
    }

    public User() {

    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name(){
        return user_name;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public String getPassword() {
        return password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getPhone() {
        return phone;
    }

    public LocalDate getTimecreated() {
        return timecreated;
    }

    public LocalDate getTimeupdated() {
        return timeupdated;
    }

    public Role getRole() {
        return role;
    }

    public Integer getProject_id() {
        return project_id;
    }

    public Collection<Project> getProjectCollection() {
        return projectCollection;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public void setTimecreated(LocalDate timecreated) {
        this.timecreated = timecreated;
    }

    public void setTimeupdated(LocalDate timeupdated) {
        this.timeupdated = timeupdated;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
    }

    public void setProjectCollection(ArrayList<Project> projectCollection) {
        this.projectCollection = projectCollection;
    }

    public void add(Project temp){
        if(projectCollection == null){
            projectCollection = new ArrayList<Project>();
        }
        projectCollection.add(temp);
    }
}
