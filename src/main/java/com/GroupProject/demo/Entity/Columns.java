package com.GroupProject.demo.Entity;

import com.GroupProject.demo.Entity.Enums.ColumnsType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="column")
public class Columns {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="col_id", nullable = false, updatable = false)
    private Integer colId;

    @Column(name="content", nullable = false, unique = true)
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(name="columns_type")
    private ColumnsType columnsType = ColumnsType.TEXT;

    @Column(name="time_created")
    private LocalDateTime timeCreated;

    @Column(name="time_updated")
    private LocalDateTime timeUpdated;

    @ManyToOne(cascade= {CascadeType.MERGE})
    @JoinColumn(name="resource_id")
    private Resource resource;

    public Integer getColId() {
        return colId;
    }

    public void setColId(Integer colId) {
        this.colId = colId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ColumnsType getColumnsType() {
        return columnsType;
    }

    public void setColumnsType(ColumnsType columnsType) {
        this.columnsType = columnsType;
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

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public String toString() {
        return "Column{" +
                "colId=" + colId +
                ", content='" + content + '\'' +
                ", columnsType=" + columnsType +
                ", timeCreated=" + timeCreated +
                ", timeUpdated=" + timeUpdated +
                ", resource=" + resource +
                '}';
    }
}
