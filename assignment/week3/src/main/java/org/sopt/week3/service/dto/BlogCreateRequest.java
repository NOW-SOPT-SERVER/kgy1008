package org.sopt.week3.service.dto;

import jakarta.validation.constraints.Size;

public record BlogCreateRequest(
        @Size(max = 10, message="블로그 제목이 최대 글자 수를 초과했습니다.")
        String title,
        String description
) {
}
