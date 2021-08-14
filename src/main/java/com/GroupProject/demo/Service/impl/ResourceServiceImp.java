package com.GroupProject.demo.Service.impl;

import com.GroupProject.demo.Entity.Resource;
import com.GroupProject.demo.Repository.ResourceRepository;
import com.GroupProject.demo.Service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class ResourceServiceImp implements ResourceService {

    @Autowired
    ResourceRepository repository;

    @Override
    public void saveresource(Resource resource) {
        resource.setTimecreated(LocalDate.now());
        resource.setTimeupdated(LocalDate.now());
        repository.save(resource);
    }

    @Override
    public Resource findbyid(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Resource findbyname(String name) {
        List<Resource> resources = repository.findAll();
        for(Resource temp : resources){
            if(temp.getname().equals(name)){
                return temp;
            }
        }
        return null;
    }

    @Override
    public Resource findbyresourcecode(Integer code) {
        List<Resource> resources = repository.findAll();
        for(Resource temp : resources){
            if(temp.getrcode().equals(code)){
                return temp;
            }
        }
        return null;
    }

    @Override
    public void updateresourcename(Resource resource) {
        resource.setTimeupdated(LocalDate.now());
        repository.save(resource);
    }

    @Override
    public void updateresourcecode(Resource resource) {
        resource.setTimeupdated(LocalDate.now());
        repository.save(resource);
    }

    @Override
    public void deletebyresource(Resource resource) {
        repository.delete(resource);
    }

    @Override
    public List<Resource> findallresources() {
        return repository.findAll();
    }

    @Override
    public boolean doesresourceexist(Resource resource) {
        Resource test = repository.findById(resource.getRid()).orElse(null);
        if(test != null){
            return true;
        }
        return false;
    }
}
