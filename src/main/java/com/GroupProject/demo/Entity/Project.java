package com.GroupProject.demo.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="project")
public class Project {
    //primary key
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="project_id", nullable = false, updatable = false)
    private Integer projectId;

    @Column(name="project_name", nullable = false, unique = true)
    private String projectName;

    @Column(name="time_created")
    private LocalDateTime timeCreated;

    @Column(name="time_updated")
    private LocalDateTime timeUpdated;

    @ManyToOne(cascade= {CascadeType.MERGE})
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="project", cascade= CascadeType.ALL)
    private List<ProjectResource> projectResource;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ProjectResource> getProjectResource() {
        return projectResource;
    }

    public void setProjectResource(List<ProjectResource> projectResource) {
        this.projectResource = projectResource;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", timeCreated=" + timeCreated +
                ", timeUpdated=" + timeUpdated +
                ", user=" + user +
                ", projectResource=" + projectResource +
                '}';
    }
}
