package org.sopt.week6.service;

import org.sopt.week6.common.dto.ErrorMessage;
import org.sopt.week6.domain.Blog;
import org.sopt.week6.domain.Member;
import org.sopt.week6.domain.Post;
import org.sopt.week6.exception.NotFoundException;
import org.sopt.week6.exception.UnauthorizedAccessException;
import org.sopt.week6.repository.PostRepository;
import org.sopt.week6.service.dto.PostCreateRequest;
import lombok.RequiredArgsConstructor;
import org.sopt.week6.service.dto.PostFindDto;
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

    public Post findById(Long postId){
        return postRepository.findById(postId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.POST_NOT_FOUND)
        );
    }

    public PostFindDto findPostById(Long postId) {
        return PostFindDto.of(findById(postId));
    }

    public List<PostFindDto> findPostsByBlogId(Long blogId) {
        List<Post> posts = postRepository.findByBlogId(blogId);
        return posts.stream().map(PostFindDto::of).toList();
    }
}
