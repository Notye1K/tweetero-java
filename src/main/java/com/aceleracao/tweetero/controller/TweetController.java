package com.aceleracao.tweetero.controller;

import org.springframework.http.HttpStatus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aceleracao.tweetero.DTO.TweetDTO;
import com.aceleracao.tweetero.model.TweetModel;
import com.aceleracao.tweetero.service.TweetService;

@RequestMapping("/api/tweets")
@RestController
public class TweetController {
    
    @Autowired
    private TweetService service;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void post(@RequestBody TweetDTO req){
        service.post(req);
    }

    @GetMapping
    public Page<TweetModel> getAll(@RequestParam("page") int page){
        return service.getAll(page);
    }

    @GetMapping("/{username}")
    public List<TweetModel> getAllByUsername(@PathVariable String username){
        return service.getAllByUser(username);
    }
}
