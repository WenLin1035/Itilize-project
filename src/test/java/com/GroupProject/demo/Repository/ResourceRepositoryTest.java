package com.GroupProject.demo.Repository;

import com.GroupProject.demo.Entity.Project;
import com.GroupProject.demo.Entity.Resource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ResourceRepositoryTest {

    @Autowired
    ResourceRepository resourceRepository;

    //Create Resource
    @Test
    public void createResourceTest(){

        //Create new resource
        Resource resource = new Resource();
        resource.setResourceName("Resource 1");
        resource.setResourceCode("00 00 00");
        resource.setTimeCreated(LocalDateTime.now());
        resource.setTimeUpdated(LocalDateTime.now());

        Resource resourceTest = resourceRepository.save(resource);

        boolean doesResourceExists = resourceRepository.existsById(resource.getResourceId());

        Assert.assertNotNull(resourceTest);
        Assert.assertTrue(doesResourceExists);
        Assert.assertEquals(resource, resourceTest);
    }

    //Read Resource
    @Test
    public void readResourceByIdTest(){
        Integer resourceId = 1;

        boolean doesResourceExists = resourceRepository.existsById(resourceId);

        Assert.assertTrue(doesResourceExists);
    }

    //Update Resource
    @Test
    public void updateResourceByIdTest(){
        Integer resourceId= 1;
        Resource expected = resourceRepository.getOne(resourceId);
        expected.setResourceName("Resource1");
        expected.setTimeUpdated(LocalDateTime.now());

        Resource actual = resourceRepository.save(expected);

        Assert.assertEquals("Resource1", actual.getResourceName());
    }

    //Delete Resource
    @Test
    public void deleteResourceByIdTest(){
        Integer resourceId= 1;
        Resource expected = resourceRepository.getOne(resourceId);

        resourceRepository.deleteById(resourceId);

        boolean actual = resourceRepository.existsById(resourceId);

        Assert.assertFalse(actual);
    }
}