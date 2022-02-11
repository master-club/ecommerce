package com.springboot.ecommerce.common.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Value
@Builder
@With
public class ResultSet<T> implements Serializable
{
    List<T> data;

    long count;
}
