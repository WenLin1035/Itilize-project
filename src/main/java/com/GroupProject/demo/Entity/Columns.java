package com.GroupProject.demo.Entity;

/*
    @Author: Wen Lin
*/
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="columns")
public class Columns {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="columnid")
    private Integer columnid;
    @Column(name="columnName")
    private String columnName;
    @Enumerated(EnumType.STRING)
    @Column(name = "col_type")
    private ColumnType columnType;
    @CreatedDate
    @Column(name = "timecreated")
    private LocalDate createdate;
    @LastModifiedDate
    @Column(name = "timeupdated")
    private LocalDate lastupdate;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="rid")
    private Resource resources;

    @Override
    public String toString(){
        return "columnid: " + columnid + " / column name: " + columnName + " / column type: "
                + columnType + " / rid: " + resources;
    }

    public Integer getColumnid() {
        return columnid;
    }

    public void setColumnid(Integer columnid) {
        this.columnid = columnid;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public ColumnType getColumnType() {
        return columnType;
    }

    public void setColumnType(ColumnType columnType) {
        this.columnType = columnType;
    }

    public LocalDate getCreatedata() {
        return createdate;
    }

    public void setCreatedata(LocalDate createdata) {
        this.createdate = createdata;
    }

    public LocalDate getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(LocalDate lastupdate) {
        this.lastupdate = lastupdate;
    }

    public Resource getResource() {
        return resources;
    }

    public void setResource(Resource resource) {
        this.resources = resource;
    }
}
