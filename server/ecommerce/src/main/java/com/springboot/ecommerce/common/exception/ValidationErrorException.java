package com.springboot.ecommerce.common.exception;

import com.springboot.ecommerce.common.error.ErrorCode;

public class ValidationErrorException extends CommonException
{
    private static final long serialVersionUID = 1L;
    private static final ErrorCode ERROR_CODE = ErrorCode.VALIDATION_ERROR;

    public ValidationErrorException(String messageTemplate, Object... args) {
        super(ERROR_CODE, messageTemplate, args);
    }
}
