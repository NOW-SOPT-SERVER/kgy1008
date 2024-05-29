package org.sopt.week6.controller;

import org.sopt.week6.auth.PrincipalHandler;
import org.sopt.week6.common.dto.SuccessMessage;
import org.sopt.week6.service.BlogService;
import org.sopt.week6.service.PostService;
import org.sopt.week6.service.dto.BlogCreateRequest;
import org.sopt.week6.service.dto.BlogTitleUpdateRequest;
import org.sopt.week6.common.dto.SuccessStatusResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sopt.week6.service.dto.PostFindDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;
    private final PostService postService;
    private final PrincipalHandler principalHandler;

    @PostMapping("/blogs")
    public ResponseEntity<SuccessStatusResponse> createBlog(
            @RequestHeader(name = "memberId") Long memberId,
            @RequestBody BlogCreateRequest blogCreateRequest
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", blogService.create(
                        principalHandler.getUserIdFromPrincipal(), blogCreateRequest
                ))
                .body(SuccessStatusResponse.of(SuccessMessage.BLOG_CREATE_SUCCESS));
    }

    @PatchMapping("/blogs/{blogId}/title")
    public ResponseEntity<Void> updateBlogTitle(
            @PathVariable Long blogId,
            @Valid @RequestBody BlogTitleUpdateRequest blogTitleUpdateRequest
    ) {
        blogService.updateTitle(blogId, blogTitleUpdateRequest);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/blogs/{blogId}/posts")
    public ResponseEntity<SuccessStatusResponse<List<PostFindDto>>> getPostsByBlogId(@PathVariable Long blogId) {
        List<PostFindDto> posts = postService.findPostsByBlogId(blogId);
        return ResponseEntity.ok(SuccessStatusResponse.of(SuccessMessage.POSTS_GET_SUCCESS, posts));
    }
}
