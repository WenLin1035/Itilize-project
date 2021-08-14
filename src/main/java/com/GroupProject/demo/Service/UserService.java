package com.GroupProject.demo.Service;

import com.GroupProject.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

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
}
