package com.ll.restByTdd.domain.post.post.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ll.restByTdd.domain.post.post.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostDto {
    private long id;
    @JsonIgnore
    private LocalDateTime createAt;
    @JsonIgn
    private LocalDateTime modifyAt;
    private String title;
    private String content;

    public PostDto(Post post) {
        this.id = post.getId();
        this.createAt = post.getCreatedAt();
        this.modifyAt = post.getModifiedAt();
        this.title = post.getTitle();
        this.content = post.getContent();
    }

    public LocalDateTime getCreateDateTime() {
        return createAt;
    }

    public LocalDateTime getModifyDateTime() {
        return modifyAt;
    }
}
