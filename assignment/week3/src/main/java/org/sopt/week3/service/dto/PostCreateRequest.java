package org.sopt.week3.service.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PostCreateRequest(
        @NotNull(message = "포스트 제목을 입력해주세요")
        @Size(min = 1, max = 20, message="블로그 제목의 글자 수는 최소 1자에서 최대 20자 사이이여야 합니다.")
        String name,
        @NotNull(message = "포스트 내용을 입력해주세요")
        String content
) {
}
