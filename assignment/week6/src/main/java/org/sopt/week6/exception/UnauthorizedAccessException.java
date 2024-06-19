package org.sopt.week6.exception;

import org.sopt.week6.common.dto.ErrorMessage;

public class UnauthorizedAccessException extends BusinessException{
    public UnauthorizedAccessException(ErrorMessage errorMessage){
        super(errorMessage);
    }
}
