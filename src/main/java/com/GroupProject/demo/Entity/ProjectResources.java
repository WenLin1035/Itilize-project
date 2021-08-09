package com.GroupProject.demo.Entity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name="project_resources")
public class ProjectResources {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="PR_id")
    private Integer PR_id;

    @ManyToOne(cascade= {CascadeType.DETACH}, targetEntity = Project.class)
    @JoinColumn(name="project_id")
    private Project project;

    @ManyToOne(cascade= {CascadeType.DETACH}, targetEntity = Resources.class)
    @JoinColumn(name="resource_id")
    private Resources resources;

    public Integer getPR_id() {
        return PR_id;
    }

    public void setPR_id(int PR_id) {
        this.PR_id = PR_id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Resources getResources() {
        return resources;
    }

    public void setResourceCatalog(Resources resources) {
        this.resources = resources;
    }

    @Override
    public String toString() {
        return "ProjectResources{" +
                "PR_id=" + PR_id +
                ", project=" + project +
                ", resourceCatalog=" + resources +
                '}';
    }
}
