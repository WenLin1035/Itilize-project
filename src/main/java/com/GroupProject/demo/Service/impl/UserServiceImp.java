package com.GroupProject.demo.Service.impl;

import com.GroupProject.demo.Entity.User;
import com.GroupProject.demo.Repository.UserRepository;
import com.GroupProject.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

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
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deletebyuser(User user) {
        userRepository.delete(user);
    }
}
