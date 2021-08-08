package com.GroupProject.demo.Entity;

import constants.Roles;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int userId;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="phone")
    private int phone;

    @Column(name="time_created")
    private LocalDateTime timeCreated;

    @Column(name="time_updated")
    private LocalDateTime timeUpdated;

    @Column(name="roles")
    private Roles ROLES;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="project_id")
    private Project project;

    /*@OneToMany(fetch=FetchType.LAZY, mappedBy="user", cascade= CascadeType.ALL)
    private List<Project> projects;*/
}
