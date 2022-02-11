package com.springboot.ecommerce.common.exception;

import com.springboot.ecommerce.common.error.ErrorCode;
import lombok.Getter;

public class CommonException extends RuntimeException
{
    @Getter
    private final ErrorCode code;

    public CommonException(ErrorCode code, String format, Object... args) {
        super(String.format(format, args));
        this.code = code;
    }
}
