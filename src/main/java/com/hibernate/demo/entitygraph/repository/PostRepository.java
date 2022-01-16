package com.hibernate.demo.entitygraph.repository;

import com.hibernate.demo.entitygraph.model.Post;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {

    @EntityGraph("postWithComments")
    List<Post> findByIsReadIs(String s);

}
