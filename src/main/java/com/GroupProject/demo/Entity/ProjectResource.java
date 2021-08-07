package com.GroupProject.demo.Entity;
/*
@author: Wen Lin
 */

import javax.persistence.*;

@Entity
@Table(name="projectresource")
public class ProjectResource {
    @Id
    @GeneratedValue
    @Column(name="id",nullable = false,unique = true)
    private Integer id;
    @ManyToOne(cascade = CascadeType.MERGE,targetEntity = Project.class)
    private Integer pr_id;
    @JoinColumn(name="project_id")
    private Integer pid;
    @JoinColumn(name="rid")
    private Integer rid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPr_id() {
        return pr_id;
    }

    public void setPr_id(Integer pr_id) {
        this.pr_id = pr_id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }
}
