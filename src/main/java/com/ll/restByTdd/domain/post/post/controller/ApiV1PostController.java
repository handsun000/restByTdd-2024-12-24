package com.ll.restByTdd.domain.post.post.controller;

import com.ll.restByTdd.domain.post.post.entity.Post;
import com.ll.restByTdd.domain.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class ApiV1PostController {

    private final PostService postService;

    @GetMapping
    public List<Post> getItems() {
        return postService.findAllByOrderByIdDesc();
    }

    @GetMapping("/{id}")
    public Post getItem(@PathVariable long id) {
        return postService.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable long id) {
        Post post = postService.findById(id);

        postService.delete(post);

        return "삭제가 완료되었습니다.";
    }
}
