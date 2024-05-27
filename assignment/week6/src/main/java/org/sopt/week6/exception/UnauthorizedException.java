package org.sopt.week6.exception;

import org.sopt.week6.common.dto.ErrorMessage;

public class UnauthorizedException extends BusinessException {
    public UnauthorizedException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}
