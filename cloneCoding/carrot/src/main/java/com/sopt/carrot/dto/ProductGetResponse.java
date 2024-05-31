package com.sopt.carrot.dto;

import com.sopt.carrot.domain.Product;
import jakarta.validation.constraints.NotBlank;

public record ProductGetResponse(
        @NotBlank
        String title,
        String description,
        @NotBlank
        int price
) {
    public static ProductGetResponse of(Product product) {
        return new ProductGetResponse(
                product.getProductName(),
                product.getDescription(),
                product.getPrice()
        );
    }
}
