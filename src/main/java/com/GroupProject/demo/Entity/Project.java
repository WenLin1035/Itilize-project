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
    @Column(name="project_id")
    private int projectId;

    @Column(name="project_name")
    private String projectName;

    @Column(name="time_created")
    private LocalDateTime timeCreated;

    @Column(name="time_updated")
    private LocalDateTime timeUpdated;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="project", cascade= CascadeType.ALL)
    private List<ProjectResources> projectResources;

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
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

    public List<ProjectResources> getProjectResources() {
        return projectResources;
    }

    public void setProjectResources(List<ProjectResources> projectResources) {
        this.projectResources = projectResources;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", timeCreated=" + timeCreated +
                ", timeUpdated=" + timeUpdated +
                ", user=" + user +
                ", projectResources=" + projectResources +
                '}';
    }
}
