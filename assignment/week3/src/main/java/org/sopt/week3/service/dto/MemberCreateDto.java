package org.sopt.week3.service.dto;

import org.sopt.week3.domain.Part;

public record MemberCreateDto(
        String name,
        Part part,
        int age
) {
}
