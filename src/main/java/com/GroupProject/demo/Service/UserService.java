package com.GroupProject.demo.Service;

import com.GroupProject.demo.Entity.User;
import com.GroupProject.demo.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Checking if user exists by Id
    public boolean userExistsById(Integer userId){
        return userRepository.existsById(userId);
    }

    //Create user
    public User createUser(User user) {

        if (!userExistsById(user.getUserId())) {
            user = new User(user.getUsername(), user.getPassword(), user.getFirstName(),
                    user.getLastName(), user.getEmail(), user.getPhone(),
                    LocalDateTime.now(), LocalDateTime.now());
        }else{
            throw new IllegalArgumentException("Username already exists!");
        }

        return userRepository.save(user);
    }

    //Find user by id
    public User findUserById(Integer userId){
        return  userRepository.findById(userId)
                .orElseThrow(()->new NoSuchElementException("User does not exits!"));
    }
    //Get all users
    List<User> getAlUsers(){
        return userRepository.findAll();
    }

    //Delete user
    public void deleteUser(User user){
        userRepository.delete(user);
    }
    //Delete user by id
    public void deleteUserById(Integer userId){
        userRepository.deleteById(userId);
    }
    //Delete all users
    public void deleteAllUsers(User user){
        userRepository.deleteAll();
    }






}
