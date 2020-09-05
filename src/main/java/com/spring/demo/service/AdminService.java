package com.spring.demo.service;/* 
@Author : Yogesh Deshmukh
*/

import com.spring.demo.model.User;
import com.spring.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    @Secured("ROLE_ADMIN")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
