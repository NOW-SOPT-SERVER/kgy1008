package org.sopt.week6.controller;

import org.sopt.week6.service.MemberService;
import org.sopt.week6.service.TokenService;
import org.sopt.week6.service.dto.MemberCreateDto;
import org.sopt.week6.service.dto.MemberFindDto;
import lombok.RequiredArgsConstructor;
import org.sopt.week6.service.dto.UserJoinResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MemberController {

    private final MemberService memberService;
    private final TokenService tokenService;

    @PostMapping("/members")
    public ResponseEntity<UserJoinResponse> createMember(
            @RequestBody MemberCreateDto memberCreate
    ) {
        UserJoinResponse userJoinResponse = memberService.createMember(memberCreate);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", userJoinResponse.userId().toString())
                .body(
                        userJoinResponse
                );
    }

    @PostMapping("/members/refresh")
    public ResponseEntity<UserJoinResponse> login(
            @RequestHeader(name = "refreshToken") String refreshToken,
            @RequestHeader(name = "userId") Long userId
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", userId.toString())
                .body(tokenService.regenerateAccessToken(refreshToken, userId));
    }

    @GetMapping("/members/{memberId}")
    public ResponseEntity<MemberFindDto> findMemberById(@PathVariable Long memberId) {
        return ResponseEntity.ok(memberService.findMemberById(memberId));
    }

    @DeleteMapping("/members/{memberId}")
    public ResponseEntity deleteMemberById(@PathVariable Long memberId){
        memberService.deleteMemberById(memberId);
        return ResponseEntity.noContent().build();
    }
}
