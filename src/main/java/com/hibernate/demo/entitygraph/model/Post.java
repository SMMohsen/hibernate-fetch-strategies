package com.hibernate.demo.entitygraph.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name = "post")
@NamedEntityGraph(name = "postWithComments" , attributeNodes = {@NamedAttributeNode(value = "comments",subgraph ="withReplies")}
,subgraphs = {@NamedSubgraph(name = "withReplies", attributeNodes = @NamedAttributeNode("replies"))})
public class Post {

    @Id
    private Long id;

    @Column(name = "content")
    private String content;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "is_read")
    private String isRead;

    @Fetch(FetchMode.SUBSELECT)
    @BatchSize(size = 5)
    @JsonManagedReference
    @OneToMany(mappedBy = "post" , fetch = FetchType.LAZY)
    private Set<PostComment> comments;

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

    public String getRead() {
        return isRead;
    }

    public void setRead(String read) {
        isRead = read;
    }

    public Set<PostComment> getComments() {
        return comments;
    }

    public void setComments(Set<PostComment> comments) {
        this.comments = comments;
    }
}
