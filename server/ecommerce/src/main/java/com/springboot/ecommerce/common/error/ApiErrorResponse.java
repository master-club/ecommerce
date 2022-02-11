package com.springboot.ecommerce.common.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
public class ApiErrorResponse
{
    @Getter
    private final ErrorCode code;

    @Getter
    private final String message;

    private final Throwable cause;
}
