package com.GroupProject.demo.Controller;

import com.GroupProject.demo.Entity.User;
import com.GroupProject.demo.Service.ServiceImplementation.UserServiceImpl;
import com.GroupProject.demo.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/korera")
public class UserController {

    private final UserService userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/korera/user/create")
                .toUriString());
        return ResponseEntity.created(uri).body(userService.getAlUsers());
    }

    @PostMapping("/user/signup")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.ok().body(userService.createUser(user));
    }
}
