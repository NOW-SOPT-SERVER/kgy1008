package org.sopt.week3.service;

import org.sopt.week3.common.dto.ErrorMessage;
import org.sopt.week3.domain.Blog;
import org.sopt.week3.domain.Member;
import org.sopt.week3.domain.Post;
import org.sopt.week3.exception.UnauthorizedAccessException;
import org.sopt.week3.repository.PostRepository;
import org.sopt.week3.service.dto.PostCreateRequest;
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

        if (!blog.getMember().equals(member)){
            throw new UnauthorizedAccessException(ErrorMessage.MEMBER_NOT_MATCH);
        }

        Post post = postRepository.save(Post.create(blog, postCreateRequest));
        return post.getId().toString();
    }
}
