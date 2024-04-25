package com.example.practice.exception;

import com.example.practice.common.dto.ErrorMessage;

public class NotFoundException extends BusinessException {
    public NotFoundException(ErrorMessage errorMessage){
        super(errorMessage);
    }
}
