package com.GroupProject.demo.Service.ServiceImplementation;

import com.GroupProject.demo.Entity.Enums.Roles;
import com.GroupProject.demo.Entity.User;
import com.GroupProject.demo.Repository.UserRepository;
import com.GroupProject.demo.Service.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service @Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Check if username exists
    @Override
    public boolean usernameExists(String username){
        return userRepository.findByUsername(username).isPresent();
    }
    //Checking if user exists by Id
    @Override
    public boolean userIdExists(Integer userId){
        return userRepository.existsById(userId);
    }

    //Create user
    @Override
    public User createUser(User user) {
        if (!usernameExists(user.getUsername())) {
            user = new User(user.getUsername(), user.getPassword(), user.getFirstName(),
                    user.getLastName(), user.getEmail(), user.getPhone(),
                    LocalDateTime.now(), LocalDateTime.now());
        }else{
            throw new IllegalArgumentException("Username already exists!");
        }
        return userRepository.save(user);
    }

    //Assign role to user
    @Override
    public void setUserRole(String username, Roles role){
        User user = userRepository.findByUsername(username)
                .orElseThrow(()->new NoSuchElementException("User does not exits!"));
        user.setROLES(role);
    }

    //Find user by username
    @Override
    public User findUserByUsername(String username){
        return  userRepository.findByUsername(username)
                .orElseThrow(()->new NoSuchElementException("User does not exits!"));
    }
    //Find user by id
    @Override
    public User findUserById(Integer userId){
        return  userRepository.findById(userId)
                .orElseThrow(()->new NoSuchElementException("User does not exits!"));
    }
    //Get all users
    @Override
    public List<User> getAlUsers(){
        return userRepository.findAll();
    }

    //Update username
    @Override
    public void updateUsername(User user, String username){
        user.setUsername(username);
        userRepository.save(user);
    }

    //Update email
    @Override
    public void updateEmail(User user, String email){
        user.setUsername(email);
        userRepository.save(user);
    }

    //Delete user by username
    @Override
    public void deleteUserByUsername(String username){
        userRepository.deleteByUsername(username);
    }
    //Delete user
    @Override
    public void deleteUser(User user){
        userRepository.delete(user);
    }
    //Delete user by id
    @Override
    public void deleteUserById(Integer userId){
        userRepository.deleteById(userId);
    }
    //Delete all users
    @Override
    public void deleteAllUsers(User user){
        userRepository.deleteAll();
    }






}
