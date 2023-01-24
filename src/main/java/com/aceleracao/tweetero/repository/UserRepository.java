package com.aceleracao.tweetero.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aceleracao.tweetero.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, String> {
    
}
