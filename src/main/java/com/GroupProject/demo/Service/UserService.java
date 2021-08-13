package com.GroupProject.demo.Service;

import com.GroupProject.demo.Entity.Enums.Roles;
import com.GroupProject.demo.Entity.User;

import java.util.List;

public interface UserService {

    boolean usernameExists(String username); // Check if username exists
    boolean userIdExists(Integer userId); // Checking if user id exists

    User createUser(User user); // Create user

    void setUserRole(String username, Roles role); //Assign role to user

    User findUserByUsername(String username); // Find user by username
    User findUserById(Integer userId); // Find user by id
    List<User> getAlUsers(); // Get all users

    void updateUsername(User user, String username); //Update username
    void updateEmail(User user, String email); //Update email

    void deleteUserByUsername(String username); // Delete user by username
    void deleteUserById(Integer userId); //Delete user by id
    void deleteUser(User user); //Delete user
    void deleteAllUsers(User user); //Delete all users

}
