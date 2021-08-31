package com.GroupProject.demo.Service;

import com.GroupProject.demo.Entity.User;

import java.util.List;
import java.util.Optional;
/*
    @Author: Wen Lin
*/
public interface UserService {
    User findbyid(Integer id);

    User findbyusername(String username);

    void updateusername(User user);

    void updatepassword(User user);

    void updateemail(User user);

    List<User> findallUsers();

    User saveUser(User user);

    void deletebyuser(User user);

    User addProjectToUser(Integer id, Integer pid);

    User deleteProjectsFromUser(Integer id);
}
