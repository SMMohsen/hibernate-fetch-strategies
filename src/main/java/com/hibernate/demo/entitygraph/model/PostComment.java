package com.hibernate.demo.entitygraph.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "post_comment")
public class PostComment {

    @Id
    private Long id;

    @Column(name = "content")
    private String content;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @ManyToOne
    @JsonBackReference
    private Post post;


    @OneToMany(mappedBy = "comment" , fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<CommentReply> replies;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Set<CommentReply> getReplies() {
        return replies;
    }

    public void setReplies(Set<CommentReply> replies) {
        this.replies = replies;
    }
}
