package com.springboot.ecommerce.common.error;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorCode
{
    BAD_REQUEST("E400000"),

    VALIDATION_ERROR("E400001"),

    NOT_FOUND("E404000"),

    RESOURCE_NOT_FOUND("E404001"),

    METHOD_NOT_ALLOWED("E405000"),

    INTERNAL_SERVER_ERROR("E500000");

    @Getter(onMethod = @__(@JsonValue))
    private final String value;

    @JsonCreator
    public static ErrorCode of(String value) {
        return Arrays.stream(values())
                .filter(v -> v.value.equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("ErrorCode = '" + value + "' is not supported."));
    }
}
