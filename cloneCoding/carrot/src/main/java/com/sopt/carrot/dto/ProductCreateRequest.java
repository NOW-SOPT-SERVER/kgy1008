package com.sopt.carrot.dto;

import jakarta.validation.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public record ProductCreateRequest(
        @NotBlank
        String title,
        String description,
        @NotBlank
        int price,
        MultipartFile image
) {
}
