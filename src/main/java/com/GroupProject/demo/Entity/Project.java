package com.GroupProject.demo.Entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

/*
@author: Wen Lin
 */

@Entity
@Table(name="project")
public class Project {
    @Id
    @GeneratedValue
    @Column(name="project_id")
    private Integer id;

    @Column(name="Project_name",nullable = false,unique = true)
    private String name;

    @CreatedDate
    @Column(name="createTime")
    private LocalDate createtime;

    @LastModifiedDate
    @Column(name="updatetime")
    private LocalDate updatetime;

    @ManyToOne(targetEntity = User.class, cascade = {CascadeType.DETACH})
    @JoinColumn(name="user_id")
    private Integer user_id;

    @Column(name="pr_id")
    private  Integer pr_id;

    @OneToMany(targetEntity = ProjectResource.class,cascade = CascadeType.REMOVE,mappedBy = "project")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<ProjectResource> resources;

    public Project(){}

    public Project(Integer pid, String name, Integer uid, Integer pr_id){
        id = pid;
        this.name = name;
        this.createtime = LocalDate.now();
        this.updatetime = LocalDate.now();
        user_id = uid;
        this.pr_id = pr_id;
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

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getPr_id() {
        return pr_id;
    }

    public void setPr_id(Integer pr_id) {
        this.pr_id = pr_id;
    }

}
