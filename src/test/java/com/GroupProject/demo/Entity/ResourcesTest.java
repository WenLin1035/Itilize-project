package com.GroupProject.demo.Entity;

import com.GroupProject.demo.Repository.ResourcesRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ResourcesTest {

    @Autowired
    ResourcesRepository resourcesRepository;

    @Test
    public void testResources(){
        Resources resources = new Resources();
        resources.setResourceName("resource2");
        resources.setResourceCode("1234");

        Resources test = resourcesRepository.save(resources);
        System.out.println(test);

        Assert.assertNotNull(test);
    }



}