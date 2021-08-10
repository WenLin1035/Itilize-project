package com.GroupProject.demo.Entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*
@author: Wen Lin
 */

@Entity
@Table(name="project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="project_id")
    private Integer id;

    @Column(name="project_name",nullable = false,unique = true)
    private String name;

    @CreatedDate
    @Column(name="createTime")
    private LocalDate createtime;

    @LastModifiedDate
    @Column(name="updatetime")
    private LocalDate updatetime;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name="user_id")
    private User user;

//    @Column(name="pr_id")
//    private Integer pr_id;

    @OneToMany(cascade = CascadeType.DETACH,mappedBy = "project",fetch = FetchType.LAZY)
    private List<ProjectResource> project;

    public Project(){}

    @Override
    public String toString(){
        return "Project Id: " + id + "/ Project name: " + name + "/ User_id" + user.getUser_id();
    }

    public void setProjectResources(ArrayList<ProjectResource> projectCollection) {
        this.project = projectCollection;
    }

    public void add(ProjectResource temp){
        if(project == null){
            project = new ArrayList<ProjectResource>();
        }
        project.add(temp);
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreatetime() {
        return createtime;
    }

    public void setCreatetime(LocalDate createtime) {
        this.createtime = createtime;
    }

    public LocalDate getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(LocalDate updatetime) {
        this.updatetime = updatetime;
    }

    public User getUser_id() {
        return user;
    }

    public void setUser_id(User user_id) {
        this.user = user_id;
    }

//    public Integer getPr_id() {
//        return pr_id;
//    }
//
//    public void setPr_id(Integer pr_id) {
//        this.pr_id = pr_id;
//    }

}
