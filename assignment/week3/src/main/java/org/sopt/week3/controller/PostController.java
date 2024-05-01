package org.sopt.week3.controller;

import org.sopt.week3.common.dto.ErrorMessage;
import org.sopt.week3.common.dto.ErrorResponse;
import org.sopt.week3.common.dto.SuccessMessage;
import org.sopt.week3.common.dto.SuccessStatusResponse;
import org.sopt.week3.exception.NotFoundException;
import org.sopt.week3.service.PostService;
import org.sopt.week3.service.dto.PostCreateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sopt.week3.service.dto.PostFindDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class PostController {

    private final PostService postService;

    @PostMapping("/post")
    public ResponseEntity<SuccessStatusResponse> createPost(
            @RequestHeader(name = "memberId") Long memberId,
            @RequestHeader(name = "blogId") Long blogId,
            @Valid @RequestBody PostCreateRequest postCreateRequest
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", postService.create(memberId, blogId, postCreateRequest))
                .body(SuccessStatusResponse.of(SuccessMessage.POST_CREATE_SUCCESS));
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<SuccessStatusResponse<PostFindDto>> getPostById(@PathVariable Long postId) {
        PostFindDto post = postService.findPostById(postId);
        return ResponseEntity.ok(SuccessStatusResponse.of(SuccessMessage.POST_FOUND_SUCCESS, post));
    }
}
