package com.ll.restByTdd.global.initData;

import com.ll.restByTdd.domain.post.post.repository.PostRepository;
import com.ll.restByTdd.domain.post.post.service.PostService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@RequiredArgsConstructor
public class BaseInitData {

    private final PostService postService;

    @Lazy
    @Autowired
    private BaseInitData self;

    @Bean
    public ApplicationRunner baseInitDataApplicationRunner() {
        return args -> {
            self.work1();
        };
    }

    @Transactional
    public void work1() {
        if (postService.count() > 0) return;

        postService.write("축구 하실 분?", "14시 까지 22명을 모아오세요");
        postService.write("농구 하실 분?", "15시 까지 12명을 모아오세요");
        postService.write("배구 하실 분?", "16시 까지 10명을 모아오세요");
    }
}
