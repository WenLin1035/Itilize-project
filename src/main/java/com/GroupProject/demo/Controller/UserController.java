package com.GroupProject.demo.Controller;

import com.GroupProject.demo.Entity.Role;
import com.GroupProject.demo.Entity.User;
import com.GroupProject.demo.Service.JwtUtil;
import com.GroupProject.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
    @Author: Wen Lin
*/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private AuthenticationManager myauthenticaitonManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping("/getalluser")
    public List<User> getallusers(){
        return service.findallUsers();
    }

    @PutMapping("/createuser")
    public void createuser(@RequestParam("user_name") String name,
                           @RequestParam("password") String pass,
                           @RequestParam("first_name") String fname,
                           @RequestParam("last_name") String lname,
                           @RequestParam("email_address") String email,
                           @RequestParam("phone") Integer phone,
                           @RequestParam("role") Role role){
        User user = new User();
        user.setUsername(name);
        user.setPassword(pass);
        user.setFirst_name(fname);
        user.setLast_name(lname);
        user.setEmail(email);
        user.setPhone(phone);
        user.setRole(role);
        service.saveUser(user);
    }
    @GetMapping("/getuserbyid")
    public User getuserbyid(@RequestBody Integer id){
        return service.findbyid(id);
    }

    @GetMapping("/getuserbyuser")
    public User getuserbyusername(@RequestParam String name){
        System.out.println(service.findbyusername(name).getUsername());
        return service.findbyusername(name);
    }

    @PutMapping("/addprojecttouser")
    public User addprojecttouser(@RequestBody Integer id,
                                 @RequestBody Integer pid){
        service.addProjectToUser(id,pid);
        return service.findbyid(id);
    }

    //sign in
    @GetMapping( "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody User User )  throws Exception {



        try {
            myauthenticaitonManager.authenticate(
                    new UsernamePasswordAuthenticationToken(User.getUsername(), User.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }


        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(User.getUsername());

        User user = service.findbyusername(User.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);
        //jwt gives token in postman switch with user to get user details
        return  new ResponseEntity<>(jwt, HttpStatus.OK);
    }

    @PutMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (service.findbyusername(user.getUsername()) != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        user.setRole(Role.User);
        return new ResponseEntity<>(service.saveUser(user), HttpStatus.CREATED);
    }
}
