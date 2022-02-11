package com.springboot.ecommerce.common.exception;

import com.springboot.ecommerce.common.error.ErrorCode;

public class UnexpectedPhantomReadCommonException extends CommonException
{
    private static final long serialVersionUID = 1L;
    private static final ErrorCode ERROR_CODE = ErrorCode.INTERNAL_SERVER_ERROR;
    private static final String MESSAGE_TEMPLATE = "Unexpected phantom read has occurred.";

    public UnexpectedPhantomReadCommonException() {
        super(ERROR_CODE, MESSAGE_TEMPLATE);
    }
}
