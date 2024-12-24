package com.ll.restByTdd.domain.post.post.controller;

import com.ll.restByTdd.domain.post.post.entity.Post;
import com.ll.restByTdd.domain.post.post.service.PostService;
import com.ll.restByTdd.global.rsData.RsData;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public RsData deleteItem(@PathVariable long id) {
        Post post = postService.findById(id);

        postService.delete(post);

        return new RsData("200-1","%d번 글을 삭제하였습니다.".formatted(id));
    }

    record PostModifyReqBody(
            @NotBlank
            @Length(min = 2)
            String title,
            @NotBlank
            @Length(min = 2)
            String content
    ) {
    }

    @PutMapping("/{id}")
    @Transactional
    public RsData modifyItem(
            @PathVariable long id,
            @RequestBody @Valid PostModifyReqBody reqBody
    ) {
        Post post = postService.findById(id);

        postService.modify(post, reqBody.title, reqBody.content);

        return new RsData("200-1","%d번 글을 삭제하였습니다.".formatted(id));
    }

    record PostWriteReqBody(
            @NotBlank
            @Length(min = 2)
            String title,
            @NotBlank
            @Length(min = 2)
            String content
    ){}

    @PostMapping
    public RsData writeItem(
            @RequestBody @Valid PostWriteReqBody reqBody
    ) {
        Post post = postService.write(reqBody.title, reqBody.content);

        return new RsData("200-1", "%d번 글이 작성되었습니다.".formatted(post.getId()));
    }
}
