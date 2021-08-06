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
    @Column(name="pr_id",nullable = false,unique = true)
    private Integer pr_id;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="project_id")
    private Project pid;
    @JoinColumn(name="rid")
    private Integer rid;

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

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }
}
