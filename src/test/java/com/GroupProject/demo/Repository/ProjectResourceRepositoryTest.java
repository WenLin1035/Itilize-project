package com.GroupProject.demo.Repository;

import com.GroupProject.demo.Entity.Project;
import com.GroupProject.demo.Entity.ProjectResource;
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
public class ProjectResourceRepositoryTest {

    @Autowired
    ProjectResourceRepository projectResourceRepository;
    @Autowired
    ResourceRepository resourceRepository;
    @Autowired
    ProjectRepository projectRepository;


    //Create ProjectResource
    @Test
    public void createProjectResourceTest(){

        //Existing project
        Integer projectId = 1;
        Project project = projectRepository.getOne(projectId);


        //Existing resource
        Integer resourceId = 4;
        Resource resource = resourceRepository.getOne(resourceId);

        //Create new resource
        ProjectResource projectResource = new ProjectResource();
        projectResource.setProject(project);
        projectResource.setResource(resource);
        projectResource.setTimeCreated(LocalDateTime.now());
        projectResource.setTimeUpdated(LocalDateTime.now());

        ProjectResource projectResourceTest = projectResourceRepository.save(projectResource);

        boolean doesProjectResourceExists = projectResourceRepository.existsById(projectResource.getPR_id());

        Assert.assertNotNull(projectResourceTest);
        Assert.assertTrue(doesProjectResourceExists);
        Assert.assertEquals(projectResource, projectResourceTest);
    }

    //Read ProjectResource
    @Test
    public void readProjectResourceByIdTest(){
        Integer projectResourceId = 1;

        boolean doesProjectResourceExists = projectResourceRepository.existsById(projectResourceId);

        Assert.assertTrue(doesProjectResourceExists);
    }


    //Delete Resource
    @Test
    public void deleteProjectResourceByIdTest(){

        Integer projectResourceId= 1;

        projectResourceRepository.deleteById(projectResourceId);

        boolean actual = projectResourceRepository.existsById(projectResourceId);

        Assert.assertFalse(actual);
    }

}