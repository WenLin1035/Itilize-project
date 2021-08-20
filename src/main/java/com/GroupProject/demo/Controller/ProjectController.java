package com.GroupProject.demo.Controller;

import com.GroupProject.demo.Entity.*;
import com.GroupProject.demo.Repository.ProjectResourceRepository;
import com.GroupProject.demo.Service.ProjectResourceService;
import com.GroupProject.demo.Service.ProjectService;
import com.GroupProject.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
/*
    @Author: Wen Lin
*/
@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService service;

    @Autowired
    private ProjectResourceService prservice;

    @Autowired
    private ProjectResourceRepository repository;

    @PutMapping("/createproject")
    public void createproject(@RequestParam("project_name") String name){
        Project project = new Project();
        project.setName(name);
        service.saveproject(project);
    }

    @GetMapping("/getprojectid")
    public Project getprojectbyid(@RequestParam("project_id") Integer id){
        return service.findbyid(id);
    }

    @GetMapping("/getprojectname")
    public Project getprojectbyname(@RequestParam("project_name") String name){
        return service.findbyname(name);
    }

    @GetMapping("/getallprojects")
    public List<Project> getallprojects(){
        return service.findallprojects();
    }

    @GetMapping("/getallresourcesforproject")
    public List<Resource> getallresourcesinprojectbyid(@RequestParam("project_id") Integer id){
        return prservice.getresourcesbyproject(id);
    }

    @PutMapping("/deleteproject")
    public void deleteproject(@RequestParam("project_id") Integer id){
        service.deletebyproject(service.findbyid(id));
    }

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
            prservice.addresourcetoproject(project, resource);
        }
    }

    @GetMapping("/getprid")
    public ProjectResource getprojectresourcebyid(@RequestParam("pr_id") Integer id){
        return prservice.findbyid(id);
    }

    @GetMapping("/getprojectbyprid")
    public Project getprojectbyprid(@RequestParam("pr_id") Integer id){
        return prservice.getprojectbyprid(id);
    }

    @GetMapping("/getresourcebyprid")
    public Resource getresourcebyprid(@RequestParam("pr_id") Integer id){
        return prservice.getresourcebyprid(id);
    }

    @PutMapping("/deleteprbyid")
    public void deleteprojectresource(@RequestParam("pr_id") Integer id){
        prservice.deleteoneprojectresource(prservice.findbyid(id));
    }
}
