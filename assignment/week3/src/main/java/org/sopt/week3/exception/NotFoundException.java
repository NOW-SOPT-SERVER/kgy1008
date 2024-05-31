package org.sopt.week3.exception;

import org.sopt.week3.common.dto.ErrorMessage;

public class NotFoundException extends BusinessException {
    public NotFoundException(ErrorMessage errorMessage){
        super(errorMessage);
    }
}
