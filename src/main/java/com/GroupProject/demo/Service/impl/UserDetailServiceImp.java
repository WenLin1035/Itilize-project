package com.GroupProject.demo.Service.impl;

import com.GroupProject.demo.Entity.User;
import com.GroupProject.demo.Repository.UserRepository;
import com.GroupProject.demo.Service.UserDetailService;
import com.GroupProject.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

@Service
public class UserDetailServiceImp implements UserDetailService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService service;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = service.findbyusername(name);
        if(user == null){
            throw new UsernameNotFoundException(name);
        }
        Collection<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().name()));
        return new org.springframework.security.core.userdetails.User(user.getUser_name(), user.getPassword(), authorities);
    }
}
