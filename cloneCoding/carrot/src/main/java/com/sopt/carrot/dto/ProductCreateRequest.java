package com.sopt.carrot.dto;

import jakarta.validation.constraints.NotBlank;

public record ProductCreateRequest(
        @NotBlank
        String title,
        String description,
        @NotBlank
        int price
) {
}
