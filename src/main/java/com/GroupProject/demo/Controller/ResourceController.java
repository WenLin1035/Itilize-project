package com.GroupProject.demo.Controller;

import com.GroupProject.demo.Entity.Columns;
import com.GroupProject.demo.Entity.Project;
import com.GroupProject.demo.Entity.Resource;
import com.GroupProject.demo.Service.ColumnsService;
import com.GroupProject.demo.Service.ProjectResourceService;
import com.GroupProject.demo.Service.ProjectService;
import com.GroupProject.demo.Service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
    @Author: Wen Lin
*/
@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService service;

    @Autowired
    private ColumnsService cservice;

    @PutMapping("/createresource")
    public Resource createresource(@RequestParam("name") String name,
                               @RequestParam("rcode") Integer rcode){
        Resource resource = new Resource();
        resource.setname(name);
        resource.setrcode(rcode);
        service.saveresource(resource);
        return service.findbyname(name);
    }

    @GetMapping("/getresourcebyid")
    public Resource getresourcebyid(@RequestParam("rid") Integer id){
        return service.findbyid(id);
    }

    @GetMapping("/getallresources")
    public List<Resource> getallresource(){
        return service.findallresources();
    }

    @PutMapping("/addcolumntoresource")
    public Resource addcolumntoresource(@RequestParam("rid") Integer id,
                                        @RequestParam("columnid") Integer cid){
        Resource resource = service.findbyid(id);
        Columns col = cservice.findbyid(cid);
        resource.add(col);
        col.setResource(resource);
        service.saveresource(resource);
        cservice.savecolumn(col);
        return service.findbyid(id);
    }

    @GetMapping("/getcolumnsinresource")
    public List<Columns> getallcolumninresource(@RequestParam("rid") Integer id){
        return service.findbyid(id).getColumnsList();
    }

    @PutMapping("/deleteresourcebyid")
    public void deleteresource(@RequestParam("rid") Integer id){
        service.deletebyresource(service.findbyid(id));
    }

    @PutMapping("updateresource")
    public Resource updateresouce(@RequestBody Resource res){
        Resource temp = service.findbyid(res.getRid());
        temp.setname(res.getname());
        temp.setrcode(res.getrcode());
        service.saveresource(temp);
        return service.findbyid(temp.getRid());
    }
}

