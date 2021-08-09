package com.GroupProject.demo.Repositiry;

import com.GroupProject.demo.Entity.Project;
import com.GroupProject.demo.Entity.User;
import com.GroupProject.demo.Repository.ProjectRepository;
import com.GroupProject.demo.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProjectRepositoryTest {
    @Autowired
    ProjectRepository projectRepository;

    @Test
    public void saveTest(){
        Project col = new Project();
        col.setName("test1");
        Project test = projectRepository.save(col);
        System.out.println(test);
    }
}
