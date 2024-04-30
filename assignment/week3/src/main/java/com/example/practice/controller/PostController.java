package com.example.practice.controller;

import com.example.practice.common.dto.SuccessMessage;
import com.example.practice.common.dto.SuccessStatusResponse;
import com.example.practice.service.PostService;
import com.example.practice.service.dto.PostCreateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
}
