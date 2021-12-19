package com.phuctai.controller;


import com.phuctai.entity.User;
import com.phuctai.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // get all employees
    @GetMapping("/employees")
    public List<User> getAllEmployees(){
        return userRepository.findAll();
    }

}
