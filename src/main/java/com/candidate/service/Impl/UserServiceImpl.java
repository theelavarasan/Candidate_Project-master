package com.candidate.service.Impl;

import com.candidate.dto.LogInDTO;
import com.candidate.dto.UserDTO;
import com.candidate.entity.ApplicationUser;
import com.candidate.repo.UserRepo;
import com.candidate.service.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo repo;


    @Override
    public String signUp(UserDTO userDTO) throws Exception {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(true);
        ApplicationUser user = mapper.map(userDTO, ApplicationUser.class);
        repo.save(user);
        return "success";
    }

    @Override
    public String login(LogInDTO logInDTO) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(true);
        ApplicationUser user = mapper.map(logInDTO, ApplicationUser.class);
        //find username and password from repository
        user = repo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        //check if username and password are correct
        if (user == null) {
            throw new RuntimeException("Username or password is incorrect");
        }
        //check if username and email are correct
        if (!user.getUsername().equals(logInDTO.getUsername()) ||!user.getEmail().equals(logInDTO.getEmail())) {
            throw new RuntimeException("Username or email is incorrect");
        }
        //find the user and return the username
        return user.getUsername()+" : "+" WelCome to Isys Technology";
    }
}
