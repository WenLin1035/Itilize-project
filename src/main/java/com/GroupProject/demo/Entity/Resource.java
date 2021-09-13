package com.GroupProject.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resources", fetch = FetchType.LAZY)
    private List<ProjectResource> projectResources;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resources", fetch = FetchType.LAZY)
    private List<Columns> columnsList;

    public Resource(){}

    @Override
    public String toString(){
        return "Resource id: " + rid + " , name: " + rcode;
    }

    public void setProjectResources(ArrayList<ProjectResource> projectCollection) {
        this.projectResources = projectCollection;
    }

    public void add(ProjectResource temp){
        if(projectResources == null){
            projectResources = new ArrayList<ProjectResource>();
        }
        projectResources.add(temp);
    }

    public List<Columns> getColumnsList(){
        return columnsList;
    }
    public void setColumns(ArrayList<Columns> projectCollection) {
        this.columnsList = projectCollection;
    }

    public void add(Columns temp){
        if(columnsList == null){
            columnsList = new ArrayList<Columns>();
        }
        columnsList.add(temp);
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
