package com.GroupProject.demo.Repositiry;

import com.GroupProject.demo.Entity.ProjectResource;
import com.GroupProject.demo.Entity.User;
import com.GroupProject.demo.Repository.ProjectResourceRepository;
import com.GroupProject.demo.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProjectResourceRepositoryTest {
    @Autowired
    ProjectResourceRepository prRepository;

    @Test
    public void saveTest(){
        ProjectResource user = new ProjectResource();
        user.setPr_id(1);
        ProjectResource test = prRepository.save(user);
        System.out.println(test);
    }
}
