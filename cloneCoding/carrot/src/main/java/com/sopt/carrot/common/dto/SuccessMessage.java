package com.sopt.carrot.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessMessage {

    PRODUCT_CREATE_SUCCESS("상품 등록 성공"),
    ;

    private final String message;
}
