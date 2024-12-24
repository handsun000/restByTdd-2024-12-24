package com.ll.restByTdd.domain.post.post.entity;

import com.ll.restByTdd.global.jpa.entity.BaseTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post extends BaseTime {

    @Column(length = 100)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;
}
