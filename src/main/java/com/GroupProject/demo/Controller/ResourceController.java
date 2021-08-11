package com.GroupProject.demo.Controller;

import com.GroupProject.demo.Entity.Columns;
import com.GroupProject.demo.Entity.Project;
import com.GroupProject.demo.Entity.Resource;
import com.GroupProject.demo.Service.ProjectResourceService;
import com.GroupProject.demo.Service.ProjectService;
import com.GroupProject.demo.Service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService service;

    @PostMapping("/createresource")
    public void createresource(@RequestParam("name") String name,
                               @RequestParam("rcode") Integer rcode){
        Resource resource = new Resource();
        resource.setname(name);
        resource.setrcode(rcode);
        service.saveresource(resource);
    }

    @GetMapping("/getresourcebyid")
    public Resource getresourcebyid(@RequestParam("rid") Integer id){
        return service.findbyid(id);
    }

    @GetMapping("/getallresources")
    public List<Resource> getallresource(){
        return service.findallresources();
    }

    @GetMapping("/getcolumnsinresource")
    public List<Columns> getallcolumninresource(@RequestParam("rid") Integer id){
        return service.findbyid(id).getColumnsList();
    }

    @PutMapping("/deleteresourcebyid")
    public void deleteresource(@RequestParam("rid") Integer id){
        service.deletebyresource(service.findbyid(id));
    }
}
