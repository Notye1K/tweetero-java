package com.aceleracao.tweetero.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aceleracao.tweetero.model.TweetModel;

public interface TweetRepository extends JpaRepository<TweetModel, Long>{
    
}
