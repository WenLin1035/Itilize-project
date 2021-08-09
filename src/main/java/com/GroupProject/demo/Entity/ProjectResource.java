package com.GroupProject.demo.Entity;
/*
@author: Wen Lin
 */

import javax.persistence.*;

@Entity
@Table(name="projectresource")
public class ProjectResource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="pr_id")
    private Integer pr_id;
    @ManyToOne(cascade = CascadeType.DETACH,targetEntity = Project.class)
    @JoinColumn(name="project_id")
    private Project project;
    @ManyToOne(targetEntity = Resource.class,cascade = CascadeType.DETACH)
    @JoinColumn(name="rid")
    private Resource resources;



    public Integer getPr_id() {
        return pr_id;
    }

    public void setPr_id(Integer pr_id) {
        this.pr_id = pr_id;
    }

    public Project getPid() {
        return project;
    }

    public void setPid(Project pid) {
        this.project = pid;
    }

    public Resource getRid() {
        return resources;
    }

    public void setRid(Resource rid) {
        this.resources = rid;
    }
}
