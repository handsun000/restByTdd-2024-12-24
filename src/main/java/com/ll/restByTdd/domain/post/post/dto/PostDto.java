package com.ll.restByTdd.domain.post.post.dto;

import com.ll.restByTdd.domain.post.post.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostDto {
    private long id;
    private LocalDateTime createAt;
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
}
