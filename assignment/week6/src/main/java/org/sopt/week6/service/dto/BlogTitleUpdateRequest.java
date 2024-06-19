package org.sopt.week6.service.dto;

import jakarta.validation.constraints.Size;

public record BlogTitleUpdateRequest(
        @Size(max = 10, message="블로그 제목이 최대 글자 수를 초과했습니다.")
        String title
) {
}
