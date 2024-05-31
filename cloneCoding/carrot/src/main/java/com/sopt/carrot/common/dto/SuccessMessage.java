package com.sopt.carrot.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessMessage {

    PRODUCT_CREATE_SUCCESS("상품 등록 성공"),
    PRODUCT_GET_SUCCESS("지역 별 상품 조회 성공"),
    HEART_CREATE_SUCCESS("찜하기 성공"),
    ;

    private final String message;
}
