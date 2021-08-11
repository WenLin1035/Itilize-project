package com.GroupProject.demo.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="resource")
public class Resource {

    //primary key
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="resource_id", nullable = false, updatable = false)
    private Integer resourceId;

    @Column(name="resource_name", nullable = false, unique = true)
    private String resourceName;

    @Column(name="resource_code", nullable = false, unique = true)
    private String resourceCode;

    @Column(name="time_created")
    private LocalDateTime timeCreated;

    @Column(name="time_updated")
    private LocalDateTime timeUpdated;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="resource", cascade= CascadeType.ALL)
    private List<ProjectResource> projectResources;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="resource", cascade= CascadeType.ALL)
    private List<Columns> columns;

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
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

    public List<ProjectResource> getProjectResources() {
        return projectResources;
    }

    public void setProjectResources(List<ProjectResource> projectResources) {
        this.projectResources = projectResources;
    }

    public List<Columns> getColumns() {
        return columns;
    }

    public void setColumns(List<Columns> columns) {
        this.columns = columns;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "resourceId=" + resourceId +
                ", resourceName='" + resourceName + '\'' +
                ", resourceCode='" + resourceCode + '\'' +
                ", timeCreated=" + timeCreated +
                ", timeUpdated=" + timeUpdated +
                ", projectResources=" + projectResources +
                ", columns=" + columns +
                '}';
    }
}
