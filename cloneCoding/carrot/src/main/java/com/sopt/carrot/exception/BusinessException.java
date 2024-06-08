package com.sopt.carrot.exception;

import com.sopt.carrot.common.dto.ErrorMessage;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private ErrorMessage errorMessage;

    public BusinessException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }
}
