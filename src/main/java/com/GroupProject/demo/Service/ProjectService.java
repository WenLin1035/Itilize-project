package com.GroupProject.demo.Service;

import com.GroupProject.demo.Entity.Project;
import com.GroupProject.demo.Entity.User;

import java.util.List;

public interface ProjectService {
    void saveproject(Project project);

    Project findbyid(Integer id);

    Project findbyname(String name);

    List<Project> findallprojects();

    List<Project> findprojectlistbyuser(User user);

    void updateprojectname(Project project);

    void deletebyproject(Project project);

    boolean doesprojectexist(Project project);
}
