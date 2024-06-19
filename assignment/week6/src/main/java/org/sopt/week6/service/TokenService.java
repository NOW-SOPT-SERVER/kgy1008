package org.sopt.week6.service;

import lombok.RequiredArgsConstructor;
import org.sopt.week6.auth.UserAuthentication;
import org.sopt.week6.common.dto.ErrorMessage;
import org.sopt.week6.common.jwt.JwtTokenProvider;
import org.sopt.week6.domain.Member;
import org.sopt.week6.domain.redis.Token;
import org.sopt.week6.exception.NotFoundException;
import org.sopt.week6.exception.UnauthorizedException;
import org.sopt.week6.repository.MemberRepository;
import org.sopt.week6.repository.redis.TokenRepository;
import org.sopt.week6.service.dto.UserJoinResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.sopt.week6.common.jwt.JwtValidationType.VALID_JWT;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final TokenRepository tokenRepository;

    @Transactional
    public UserJoinResponse regenerateAccessToken(
            String refreshToken,
            Long userId
    ) {
        Member member = memberRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND));

        Token token = tokenRepository.findByRefreshToken(refreshToken);

        if (refreshToken.equals(token.getRefreshToken()) && jwtTokenProvider.validateToken(refreshToken) == VALID_JWT) {
            String accessToken = generateAccessToken(member.getId());
            return UserJoinResponse.of(accessToken, refreshToken, member.getId());
        }

        throw new UnauthorizedException(ErrorMessage.JWT_UNAUTHORIZED_EXCEPTION);
    }

    private String generateAccessToken(Long memberId) {
        return jwtTokenProvider.issueAccessToken(
                UserAuthentication.createUserAuthentication(memberId)
        );
    }
}
