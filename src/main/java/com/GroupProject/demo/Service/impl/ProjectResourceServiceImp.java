package com.GroupProject.demo.Service.impl;

import com.GroupProject.demo.Entity.Project;
import com.GroupProject.demo.Entity.ProjectResource;
import com.GroupProject.demo.Entity.Resource;
import com.GroupProject.demo.Repository.ProjectResourceRepository;
import com.GroupProject.demo.Service.ProjectResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProjectResourceServiceImp implements ProjectResourceService {

    @Autowired
    ProjectResourceRepository repository;

    @Override
    public ProjectResource findbyid(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void saveprojectresource(ProjectResource pr) {
        repository.save(pr);
    }

    @Override
    public void addresourcetoproject(Project project, Resource resource) {
        ProjectResource pr = new ProjectResource();
        pr.setPid(project);
        pr.setRid(resource);
        repository.save(pr);
    }

    @Override
    public Project getprojectbyprid(Integer prid) {
        ProjectResource allpr = repository.findById(prid).orElse(null);
        return allpr.getPid();
    }

    @Override
    public Resource getresourcebyprid(Integer prid) {
        ProjectResource allpr = repository.findById(prid).orElse(null);
        return allpr.getRid();
    }

    @Override
    public void deleteoneprojectresource(ProjectResource pr) {
        repository.delete(pr);
    }

    @Override
    public void deleteresourcefromproject(Resource resource, Project project) {
        List<ProjectResource> pr = repository.findAll();
        for(ProjectResource temp : pr){
            if(temp.getRid().equals(resource) && temp.getPid().equals(project)){
                repository.delete(temp);
            }
        }
    }
}
