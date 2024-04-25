package com.example.practice.service.dto;

import com.example.practice.domain.Part;

public record MemberCreateDto(
        String name,
        Part part,
        int age
) {
}
