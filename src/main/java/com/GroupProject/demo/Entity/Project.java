package com.GroupProject.demo.Entity;

import javax.persistence.*;

@Entity
@Table(name="project")
public class Project {
    //primary key
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="project_code")
    private int projectCode;

    @Column(name="project_name")
    private String projectName;

    public int getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(int projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return "Project [projectCode= " + projectCode + ", projectName= '" + projectName + "']";
    }
}
