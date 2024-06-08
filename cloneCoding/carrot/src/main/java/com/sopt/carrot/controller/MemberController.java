package com.sopt.carrot.controller;

import com.sopt.carrot.common.dto.SuccessMessage;
import com.sopt.carrot.common.dto.SuccessStatusResponse;
import com.sopt.carrot.service.HeartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class MemberController {

    private final HeartService heartService;

    @PostMapping("/hearts/{productId}")
    public ResponseEntity<SuccessStatusResponse> createHeart(
            @PathVariable Long productId,
            @RequestHeader(name = "memberId") Long memberId
    ) {
        heartService.createHeart(productId, memberId);
        return ResponseEntity.ok(SuccessStatusResponse.of(SuccessMessage.HEART_CREATE_SUCCESS.getMessage()));
    }
}
