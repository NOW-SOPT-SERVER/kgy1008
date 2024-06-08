package com.sopt.carrot.exception;

import com.sopt.carrot.common.dto.ErrorMessage;

public class AuthorizationException extends BusinessException {
    public AuthorizationException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}
