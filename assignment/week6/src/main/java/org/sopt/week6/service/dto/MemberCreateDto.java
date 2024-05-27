package org.sopt.week6.service.dto;

import org.sopt.week6.domain.Part;

public record MemberCreateDto(
        String name,
        Part part,
        int age
) {
}
