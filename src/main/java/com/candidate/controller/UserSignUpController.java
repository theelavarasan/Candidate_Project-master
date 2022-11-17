package com.candidate.controller;

import com.candidate.dto.LogInDTO;
import com.candidate.dto.UserDTO;
import com.candidate.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class UserSignUpController {

    @Autowired
    private UserServiceImpl service;

    //create User SignUpController
    @PostMapping("/signUp")
    public String signUp(@RequestBody UserDTO userDTO) throws Exception {
        return service.signUp(userDTO);
    }

    // create login form for the user
    @GetMapping("/login")
    public String login(@RequestBody LogInDTO logInDTO) throws Exception {
        return service.login(logInDTO);
    }
}
