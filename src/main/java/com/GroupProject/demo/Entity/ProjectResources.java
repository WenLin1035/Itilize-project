package com.GroupProject.demo.Entity;

import javax.persistence.*;

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

    @ManyToOne(cascade= {CascadeType.DETACH}, targetEntity = Resource.class)
    @JoinColumn(name="resource_id")
    private Resource resource;

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

    public Resource getResources() {
        return resource;
    }

    public void setResourceCatalog(Resource resource) {
        this.resource = resource;
    }

    @Override
    public String toString() {
        return "ProjectResources{" +
                "PR_id=" + PR_id +
                ", project=" + project +
                ", resourceCatalog=" + resource +
                '}';
    }
}
