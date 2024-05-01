package org.sopt.week3.service.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PostCreateRequest(
        @NotNull(message = "포스트 제목을 입력해주세요")
        @Size(min = 1, max = 20, message="게시글 제목이 최대 글자 수(20자)를 초과하였습니다.")
        String name,
        @NotNull(message = "포스트 내용을 입력해주세요")
        String content
) {
}
