package org.sopt.week3.exception;

import org.sopt.week3.common.dto.ErrorMessage;

public class UnauthorizedAccessException extends BusinessException{
    public UnauthorizedAccessException(ErrorMessage errorMessage){
        super(errorMessage);
    }
}
