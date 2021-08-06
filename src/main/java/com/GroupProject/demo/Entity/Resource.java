package com.GroupProject.demo.Entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
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
@Table(name="resource")
public class Resource {
    @Id
    @GeneratedValue
    @Column(name="rid")
    private Integer rid;

    @Column(name="name")
    private String name;

    @Column(name="rcode")
    private Integer rcode;

    @CreatedDate
    @Column(name="timecreated")
    private LocalDate timecreated;

    @LastModifiedDate
    @Column(name="timeupdated")
    private LocalDate timeupdated;

    @OneToMany(targetEntity = ProjectResource.class, cascade = CascadeType.ALL, mappedBy = "Resource")
    @LazyCollection(LazyCollectionOption.TRUE)
    private Collection<ProjectResource> projectResources;

    @OneToMany(targetEntity = Columns.class,cascade = CascadeType.ALL, mappedBy = "Resource", fetch = FetchType.LAZY)
    private List<Columns> columnsList = new ArrayList<>();

    public Resource(){}

    public Resource(String name, Integer rcode){
        this.name = name;
        this.rcode = rcode;
//        this.prid = prid;
//        this.columnid = columnid;
        this.timecreated = LocalDate.now();
        this.timeupdated = LocalDate.now();
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getRid() {
        return rid;
    }
    public String getname(){
        return name;
    }
    public void setname(String name){
        this.name = name;
    }
    public Integer getrcode(){
        return rcode;
    }
    public void setrcode(Integer rcode){
        this.rcode = rcode;
    }

    public void setTimecreated(LocalDate timecreated) {
        this.timecreated = timecreated;
    }

    public LocalDate getTimecreated() {
        return timecreated;
    }

    public void setTimeupdated(LocalDate timeupdated) {
        this.timeupdated = timeupdated;
    }

    public LocalDate getTimeupdated() {
        return timeupdated;
    }
//    public Integer getPrid(){
//        return prid;
//    }
//    public void setPrid(Integer prid){
//        this.prid = prid;
//    }
//
//    public Integer getColumnid(){
//        return columnid;
//    }
//
//    public void setColumnid(Integer columnid) {
//        this.columnid = columnid;
//    }
}
