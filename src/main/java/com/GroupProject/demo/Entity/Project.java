package com.GroupProject.demo.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="user_id")
    private User user;


}
