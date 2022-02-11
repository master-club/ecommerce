package com.springboot.ecommerce.common.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class SortParam
{
    private String property = "id";

    private String direction = "ASC";

    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public enum Direction
    {
        ASC("ASC"),

        DESC("DESC");

        @Getter(onMethod = @__(@JsonValue))
        private final String value;

        @JsonCreator
        public static Direction fromDirection(String value) {
            return Arrays.stream(values())
                    .filter((v) -> v.value.equalsIgnoreCase(value))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Direction = '" + value + "' is not supported."));
        }
    }
}
