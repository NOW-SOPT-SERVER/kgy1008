package org.sopt.week6.service.dto;

import jakarta.validation.constraints.NotNull;

public record UserJoinResponse(
        @NotNull
        String accessToken,
        @NotNull
        String refreshToken,
        Long userId
) {
    public static UserJoinResponse of(
            String accessToken,
            String refreshToken,
            Long userId
    ) {
        return new UserJoinResponse(accessToken, refreshToken, userId);
    }
}
