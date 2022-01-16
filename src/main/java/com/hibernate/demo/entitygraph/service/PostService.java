package com.hibernate.demo.entitygraph.service;

import com.hibernate.demo.entitygraph.model.Post;
import com.hibernate.demo.entitygraph.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;


    public List<Post> getAll() {

        List<Post> posts = postRepository.findAll();


        return posts;
    }

    public List<Post> getIsReadTrue() {

        List<Post> posts = postRepository.findByIsReadIs("T");

        return posts;
    }

}
