package org.sopt.week6.controller;

import org.sopt.week6.common.dto.SuccessMessage;
import org.sopt.week6.common.dto.SuccessStatusResponse;
import org.sopt.week6.service.PostService;
import org.sopt.week6.service.dto.PostCreateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sopt.week6.service.dto.PostFindDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    public ResponseEntity<SuccessStatusResponse> createPost(
            @RequestHeader(name = "memberId") Long memberId,
            @RequestHeader(name = "blogId") Long blogId,
            @Valid @RequestBody PostCreateRequest postCreateRequest
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", postService.create(memberId, blogId, postCreateRequest))
                .body(SuccessStatusResponse.of(SuccessMessage.POST_CREATE_SUCCESS));
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<SuccessStatusResponse<PostFindDto>> getPostById(@PathVariable Long postId) {
        PostFindDto post = postService.findPostById(postId);
        return ResponseEntity.ok(SuccessStatusResponse.of(SuccessMessage.POST_FOUND_SUCCESS, post));
    }

    @GetMapping("/blog/{blogId}/posts")
    public ResponseEntity<SuccessStatusResponse<List<PostFindDto>>> getPostsByBlogId(@PathVariable Long blogId) {
        List<PostFindDto> posts = postService.findPostsByBlogId(blogId);
        return ResponseEntity.ok(SuccessStatusResponse.of(SuccessMessage.POSTS_GET_SUCCESS, posts));
    }

}
