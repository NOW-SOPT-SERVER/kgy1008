package com.example.practice.service;

import com.example.practice.domain.Blog;
import com.example.practice.domain.Member;
import com.example.practice.domain.Post;
import com.example.practice.repository.PostRepository;
import com.example.practice.service.dto.PostCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final MemberService memberService;
    private final BlogService blogService;
    private final PostRepository postRepository;

    public String create(Long memberId, Long blogId, PostCreateRequest postCreateRequest) {
        Member member = memberService.findById(memberId);
        Blog blog = blogService.findById(blogId);
        Post post = postRepository.save(Post.create(blog, postCreateRequest));
        return post.getId().toString();
    }
}
