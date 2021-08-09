package com.GroupProject.demo.Repositiry;

import com.GroupProject.demo.Entity.Resource;
import com.GroupProject.demo.Entity.User;
import com.GroupProject.demo.Repository.ResourceRepository;
import com.GroupProject.demo.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ResourceRepositoryTest {
    @Autowired
    ResourceRepository resourceRepository;

    @Test
    public void saveTest(){
        Resource resource = new Resource();
        resource.setname("resource1");
        resource.setrcode(333333);
        Resource test = resourceRepository.save(resource);
        System.out.println(test);
    }
}
