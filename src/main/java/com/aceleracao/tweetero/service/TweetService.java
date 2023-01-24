package com.aceleracao.tweetero.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.aceleracao.tweetero.DTO.TweetDTO;
import com.aceleracao.tweetero.model.TweetModel;
import com.aceleracao.tweetero.repository.TweetRepository;
import com.aceleracao.tweetero.repository.UserRepository;

@Service
public class TweetService {
    
    @Autowired
    private TweetRepository tweetRepository;

    @Autowired
    private UserRepository userRepository;

    public void post(TweetDTO req){
        var user = userRepository.findById(req.username());
        tweetRepository.save(new TweetModel(user.get().getUsername(), user.get().getAvatar(), req.tweet()));
    }

    public Page<TweetModel> getAll(int page){
        Pageable myPage = PageRequest.of(page, 2, Sort.by("id").descending());

        return tweetRepository.findAll(myPage);
    }

    public List<TweetModel> getAllByUser(String user){
        TweetModel tweet = new TweetModel();
        tweet.setUsername(user);
        Example<TweetModel> example = Example.of(tweet);
        return tweetRepository.findAll(example);
    }
}
