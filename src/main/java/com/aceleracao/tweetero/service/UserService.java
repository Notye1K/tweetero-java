package com.aceleracao.tweetero.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aceleracao.tweetero.DTO.UserDTO;
import com.aceleracao.tweetero.model.UserModel;
import com.aceleracao.tweetero.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    public void SignUp(UserDTO body){
        repository.save(new UserModel(body));
    }

}
