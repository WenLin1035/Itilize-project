package com.GroupProject.demo.Service.impl;

import com.GroupProject.demo.Entity.Project;
import com.GroupProject.demo.Entity.ProjectResource;
import com.GroupProject.demo.Entity.Resource;
import com.GroupProject.demo.Repository.ProjectRepository;
import com.GroupProject.demo.Repository.ProjectResourceRepository;
import com.GroupProject.demo.Repository.ResourceRepository;
import com.GroupProject.demo.Service.ProjectResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/*
    @Author: Wen Lin
*/
@Service
public class ProjectResourceServiceImpl implements ProjectResourceService {

    @Autowired
    ProjectResourceRepository repository;

    @Autowired
    ProjectRepository prepository;

    @Autowired
    ResourceRepository rrepository;


    @Override
    public ProjectResource findbyid(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void saveprojectresource(ProjectResource pr) {
        repository.save(pr);
    }

    @Override
    public void addresourcetoproject(Integer project, Integer resource) {
        ProjectResource pr = new ProjectResource();
        Project temp = prepository.findById(project).orElse(null);
        Resource temp1 = rrepository.findById(resource).orElse(null);
        if(temp != null && temp1 != null){
            pr.setPid(temp);
            pr.setRid(temp1);
            repository.save(pr);
        }
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
    public List<ProjectResource> getallpr() {
        return repository.findAll();
    }

    @Override
    public List<Resource> getresourcesbyproject(Integer id) {
        List<Resource> listresource = new ArrayList<>();
        List<ProjectResource> pr = repository.findAll();
        for(ProjectResource temp : pr){
            if(temp.getPid().getId().equals(id)){
                listresource.add(temp.getRid());
            }
        }
        return listresource;
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
