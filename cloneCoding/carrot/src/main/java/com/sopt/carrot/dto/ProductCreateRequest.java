package com.sopt.carrot.dto;

public record ProductCreateRequest(
        String title,
        String description,
        int price
) {
}
