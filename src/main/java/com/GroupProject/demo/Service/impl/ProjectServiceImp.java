package com.GroupProject.demo.Service.impl;

import com.GroupProject.demo.Entity.Project;
import com.GroupProject.demo.Entity.User;
import com.GroupProject.demo.Repository.ProjectRepository;
import com.GroupProject.demo.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ProjectServiceImp implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void saveproject(Project project) {
        project.setCreatetime(LocalDate.now());
        project.setUpdatetime(LocalDate.now());
        projectRepository.save(project);
    }

    @Override
    public Project findbyid(Integer id) {
        return projectRepository.findById(id).orElse(null);
    }

    @Override
    public Project findbyname(String name) {
        List<Project> projects = projectRepository.findAll();
        for(Project temp: projects){
            if(temp.getName().equals(name)){
                return temp;
            }
        }
        return null;
    }

    @Override
    public List<Project> findallprojects() {
        return projectRepository.findAll();
    }

    @Override
    public List<Project> findprojectlistbyuser(User user) {
        List<Project> projects = projectRepository.findAll();
        List<Project> result = new ArrayList<>();
        for(Project temp: projects){
            if(temp.getUser_id().equals(user.getUser_id())){
                result.add(temp);
            }
        }
        return result;
    }

    @Override
    public void updateprojectname(Project project) {
        project.setUpdatetime(LocalDate.now());
        projectRepository.save(project);
    }

    @Override
    public void deletebyproject(Project project) {
        projectRepository.delete(project);
    }

    @Override
    public boolean doesprojectexist(Project project) {
        Project temp = projectRepository.findById(project.getId()).orElse(null);
        if(temp != null){
            return true;
        }else
        return false;
    }
}
