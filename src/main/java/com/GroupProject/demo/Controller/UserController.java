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

    @PostMapping("/createuser")
    public void createuser(@RequestParam("user_name") String name,
                           @RequestParam("password") String pass,
                           @RequestParam("first_name") String fname,
                           @RequestParam("last_name") String lname,
                           @RequestParam("email_address") String email,
                           @RequestParam("phone") Integer phone,
                           @RequestParam("role") Role role){
        User user = new User();
        user.setUser_name(name);
        user.setPassword(pass);
        user.setFirst_name(fname);
        user.setLast_name(lname);
        user.setEmail(email);
        user.setPhone(phone);
        user.setRole(role);
        service.saveUser(user);
    }

    @GetMapping("/getuserbyuserandpass")
    public User getuserbyusernameandpassword(@RequestParam("user_name") String name,
                                             @RequestParam("password") String pass){
        User user = service.findbyusername(name);
        if(user.getPassword().equals(pass)){
            return user;
        }else
            return null;
    }

    @GetMapping("/getuserbyid")
    public User getuserbyid(@RequestParam("user_id") Integer id){
        return service.findbyid(id);
    }

    @GetMapping("/getuserbyuser")
    public User getuserbyusername(@RequestParam("user_name") String name){
        return service.findbyusername(name);
    }

    //sign in
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody User User) throws Exception {

        try {
            myauthenticaitonManager.authenticate(
                    new UsernamePasswordAuthenticationToken(User.getUser_name(), User.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }


        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(User.getUser_name());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return  new ResponseEntity<>(User, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (service.findbyusername(user.getUser_name()) != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        user.setRole(Role.User);
        return new ResponseEntity<>(service.saveUser(user), HttpStatus.CREATED);
    }
}
