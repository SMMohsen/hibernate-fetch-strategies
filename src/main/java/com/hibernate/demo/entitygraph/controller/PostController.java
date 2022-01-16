package com.hibernate.demo.entitygraph.controller;

import com.hibernate.demo.entitygraph.model.Post;
import com.hibernate.demo.entitygraph.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;


    @GetMapping
    public List<Post> getAll() {

        return postService.getAll();
    }

    @GetMapping("/is-read")
    public List<Post> getIsReadTrue() {

        return postService.getIsReadTrue();
    }
}
