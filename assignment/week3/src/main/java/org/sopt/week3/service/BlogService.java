package org.sopt.week3.service;

import org.sopt.week3.common.dto.ErrorMessage;
import org.sopt.week3.domain.Blog;
import org.sopt.week3.domain.Member;
import org.sopt.week3.exception.NotFoundException;
import org.sopt.week3.repository.BlogRepository;
import org.sopt.week3.service.dto.BlogCreateRequest;
import org.sopt.week3.service.dto.BlogTitleUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;
    private final MemberService memberService;

    public String create(Long memberId, BlogCreateRequest blogCreateRequest) {
        Member member = memberService.findById(memberId);
        Blog blog = blogRepository.save(Blog.create(member, blogCreateRequest));
        return blog.getId().toString();
    }

    public Blog findById(Long blogId) {
        return blogRepository.findById(blogId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.BLOG_NOT_FOUND)
        );
    }

    @Transactional
    public void updateTitle(Long blogId, BlogTitleUpdateRequest blogTitleUpdateRequest) {
        Blog blog = findById(blogId);
        blog.updateTitle(blogTitleUpdateRequest);
    }
}
