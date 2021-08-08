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
    @JoinColumn(name="pr_id")
    private Integer pr_id;
    @ManyToOne(cascade = CascadeType.MERGE,targetEntity = Project.class)
    @JoinColumn(name="project_id")
    private Project pid;
    @ManyToOne(targetEntity = Resource.class,cascade = CascadeType.MERGE)
    @JoinColumn(name="rid")
    private Resource rid;

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

    public Project getPid() {
        return pid;
    }

    public void setPid(Project pid) {
        this.pid = pid;
    }

    public Resource getRid() {
        return rid;
    }

    public void setRid(Resource rid) {
        this.rid = rid;
    }
}
