package com.GroupProject.demo.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="project_resource")
public class ProjectResource {

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

    @Column(name="time_created")
    private LocalDateTime timeCreated;

    @Column(name="time_updated")
    private LocalDateTime timeUpdated;

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

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }

    public LocalDateTime getTimeUpdated() {
        return timeUpdated;
    }

    public void setTimeUpdated(LocalDateTime timeUpdated) {
        this.timeUpdated = timeUpdated;
    }

    @Override
    public String toString() {
        return "ProjectResource{" +
                "PR_id=" + PR_id +
                ", project=" + project +
                ", resourceCatalog=" + resource +
                '}';
    }
}
