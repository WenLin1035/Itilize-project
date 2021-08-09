package com.GroupProject.demo.Entity;

import javax.persistence.*;

@Entity
@Table(name="project_resources")
public class ProjectResources {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PR_id")
    private int PR_id;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="project_id")
    private Project project;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="resource_id")
    private ResourceCatalog resourceCatalog;

    public int getPR_id() {
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

    public ResourceCatalog getResourceCatalog() {
        return resourceCatalog;
    }

    public void setResourceCatalog(ResourceCatalog resourceCatalog) {
        this.resourceCatalog = resourceCatalog;
    }

    @Override
    public String toString() {
        return "ProjectResources{" +
                "PR_id=" + PR_id +
                ", project=" + project +
                ", resourceCatalog=" + resourceCatalog +
                '}';
    }
}
