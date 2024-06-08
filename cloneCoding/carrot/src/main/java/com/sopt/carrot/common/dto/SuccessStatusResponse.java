package com.sopt.carrot.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import static lombok.AccessLevel.PRIVATE;

@Builder(access = PRIVATE)
public record SuccessStatusResponse(
        String message,
        @JsonInclude(value = JsonInclude.Include.NON_NULL) Object data
) {

    public static SuccessStatusResponse of(String message) {
        return SuccessStatusResponse.builder()
                .message(message)
                .build();
    }

    public static SuccessStatusResponse of(String message, Object data) {
        return SuccessStatusResponse.builder()
                .message(message)
                .data(data)
                .build();
    }
}
