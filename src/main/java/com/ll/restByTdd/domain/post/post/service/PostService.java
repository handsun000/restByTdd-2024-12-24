package com.ll.restByTdd.domain.post.post.service;

import com.ll.restByTdd.domain.post.post.entity.Post;
import com.ll.restByTdd.domain.post.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public long count() {
        return postRepository.count();
    }

    public Post write(String title, String content) {

        Post post = Post.builder()
                .title(title)
                .content(content)
                .build();

        return postRepository.save(post);
    }

    public List<Post> findAllByOrderByIdDesc() {
        return postRepository.findAllByOrderByIdDesc();
    }

    public Post findById(long id) {
        return postRepository.findById(id).get();
    }

    public void delete(Post post) {
        postRepository.delete(post);
    }

    public void modify(Post post, String title, String content) {
        post.setTitle(title);
        post.setContent(content);
    }
}
