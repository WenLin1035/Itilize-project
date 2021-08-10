package com.GroupProject.demo.Servicetest;

import com.GroupProject.demo.Entity.Project;
import com.GroupProject.demo.Entity.Resource;
import com.GroupProject.demo.Service.ProjectService;
import com.GroupProject.demo.Service.ResourceService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ResourceServiceTest {

    @Autowired
    ResourceService resourceService;

    @Test
    public void saveTest(){
        Resource resource = new Resource();
        resource.setname("test");
        resource.setrcode(1111);
        resourceService.saveresource(resource);
    }

    @Test
    public void updatenameTest(){
        Resource resource = resourceService.findbyid(6);
        resource.setname("test1");
        resourceService.updateresourcename(resource);
    }
}
