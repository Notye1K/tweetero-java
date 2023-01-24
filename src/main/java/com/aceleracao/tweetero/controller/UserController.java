package com.aceleracao.tweetero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aceleracao.tweetero.DTO.UserDTO;
import com.aceleracao.tweetero.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;
    
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void SignUp(@RequestBody UserDTO req){
        service.SignUp(req);
    }
}
