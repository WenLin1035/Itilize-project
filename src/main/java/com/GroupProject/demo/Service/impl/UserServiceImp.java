package com.GroupProject.demo.Service.impl;

import com.GroupProject.demo.Entity.Project;
import com.GroupProject.demo.Entity.User;
import com.GroupProject.demo.Repository.ProjectRepository;
import com.GroupProject.demo.Repository.UserRepository;
import com.GroupProject.demo.Service.ProjectService;
import com.GroupProject.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository passRespository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User findbyid(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User findbyusername(String username) {
        List<User> users = userRepository.findAll();
        for(User temp:users){
            if(temp.getUser_name().equals(username)){
                return temp;
            }
        }
        return null;
    }

    @Override
    public void updateusername(User user) {
        userRepository.save(user);
    }

    @Override
    public void updatepassword(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateemail(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findallUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setTimecreated(LocalDate.now());
        user.setTimeupdated(LocalDate.now());
        return userRepository.save(user);
    }

    @Override
    public void deletebyuser(User user) {
        userRepository.delete(user);
    }

    @Override
    public User addProjectToUser(Integer id, Integer pid) {
        User user = userRepository.findById(id).orElse(null);
        Project project = passRespository.findById(pid).orElse(null);
        user.addproject(project);
        project.setUser_id(user);
        user.setTimeupdated(LocalDate.now());
        return null;
    }
}
