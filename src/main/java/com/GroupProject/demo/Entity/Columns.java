package com.GroupProject.demo.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="columns")
public class Columns {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="col_id")
    private int colId;

    @Column(name="content")
    private String content;

    @Column(name="columns_type")
    private ColumnsType columnsType;

    @Column(name="time_created")
    private LocalDateTime timeCreated;

    @Column(name="time_updated")
    private LocalDateTime timeUpdated;

    @ManyToOne(cascade= {CascadeType.MERGE})
    @JoinColumn(name="resource_id")
    private Resources resources;

    public int getColId() {
        return colId;
    }

    public void setColId(int colId) {
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

    public Resources getResources() {
        return resources;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }

    @Override
    public String toString() {
        return "Columns{" +
                "colId=" + colId +
                ", content='" + content + '\'' +
                ", columnsType=" + columnsType +
                ", timeCreated=" + timeCreated +
                ", timeUpdated=" + timeUpdated +
                ", resources=" + resources +
                '}';
    }
}
