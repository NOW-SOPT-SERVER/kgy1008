package org.sopt.week6.exception;

import org.sopt.week6.common.dto.ErrorMessage;

public class NotFoundException extends BusinessException {
    public NotFoundException(ErrorMessage errorMessage){
        super(errorMessage);
    }
}
