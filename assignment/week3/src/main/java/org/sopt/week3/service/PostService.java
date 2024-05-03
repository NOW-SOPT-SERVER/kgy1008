package org.sopt.week3.service;

import org.sopt.week3.common.dto.ErrorMessage;
import org.sopt.week3.domain.Blog;
import org.sopt.week3.domain.Member;
import org.sopt.week3.domain.Post;
import org.sopt.week3.exception.NotFoundException;
import org.sopt.week3.exception.UnauthorizedAccessException;
import org.sopt.week3.repository.PostRepository;
import org.sopt.week3.service.dto.PostCreateRequest;
import lombok.RequiredArgsConstructor;
import org.sopt.week3.service.dto.PostFindDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final MemberService memberService;
    private final BlogService blogService;
    private final PostRepository postRepository;

    @Transactional
    public String create(Long memberId, Long blogId, PostCreateRequest postCreateRequest) {
        Member member = memberService.findById(memberId);
        Blog blog = blogService.findById(blogId);
        checkAuthor(blog, member);
        Post post = postRepository.save(Post.create(blog, postCreateRequest));
        return post.getId().toString();
    }

    private void checkAuthor(Blog blog, Member member) {
        if (!blog.getMember().equals(member)) {
            throw new UnauthorizedAccessException(ErrorMessage.MEMBER_NOT_MATCH);
        }
    }

    public PostFindDto findPostById(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.POST_NOT_FOUND));
        return PostFindDto.of(post);
    }

    public List<PostFindDto> findPostsByBlogId(Long blogId) {
        List<Post> posts = postRepository.findByBlogId(blogId);
        return posts.stream().map(PostFindDto::of).toList();
    }
}
