package com.GroupProject.demo.Entity;

import javax.persistence.*;

@Entity
@Table(name="resource_catalog")
public class ResourceCatalog {

    //primary key
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="resource_code")
    private int resourceCode;

    @Column(name="resource_name")
    private String resourceName;

    public int getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(int resourceCode) {
        this.resourceCode = resourceCode;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    @Override
    public String toString() {
        return "ResourceCatalog [resourceCode= " + resourceCode + ", resourceName= '" + resourceName + "']";
    }
}
