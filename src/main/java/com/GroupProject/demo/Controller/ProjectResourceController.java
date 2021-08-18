package com.GroupProject.demo.Controller;

import com.GroupProject.demo.Entity.Project;
import com.GroupProject.demo.Entity.ProjectResource;
import com.GroupProject.demo.Entity.Resource;
import com.GroupProject.demo.Repository.ProjectResourceRepository;
import com.GroupProject.demo.Service.ProjectResourceService;
import com.GroupProject.demo.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
    @Author: Wen Lin
*/
@RestController
@RequestMapping("/projectresource")
public class ProjectResourceController {

    @Autowired
    private ProjectResourceService service;

    @Autowired
    private ProjectResourceRepository repository;

    @PutMapping("/createprojectresource")
    public void createprojectresource(@RequestParam("project_id") Project project,
                                      @RequestParam("rid") Resource resource){
        boolean exist = false;
        List<ProjectResource> list = repository.findAll();
        for(ProjectResource temp: list){
            if(temp.getPid().equals(project) && temp.getRid().equals(resource)){
                exist = true;
            }
        }
        if(exist == false){
            System.out.println("added");
            service.addresourcetoproject(project, resource);
        }
    }

    @GetMapping("/getprid")
    public ProjectResource getprojectresourcebyid(@RequestParam("pr_id") Integer id){
        return service.findbyid(id);
    }

    @GetMapping("/getprojectbyid")
    public Project getprojectbyid(@RequestParam("pr_id") Integer id){
        return service.getprojectbyprid(id);
    }

    @GetMapping("/getresourcebyid")
    public Resource getresourcebyid(@RequestParam("pr_id") Integer id){
        return service.getresourcebyprid(id);
    }

    @PutMapping("/deleteprbyid")
    public void deleteprojectresource(@RequestParam("pr_id") Integer id){
        service.deleteoneprojectresource(service.findbyid(id));
    }
}
