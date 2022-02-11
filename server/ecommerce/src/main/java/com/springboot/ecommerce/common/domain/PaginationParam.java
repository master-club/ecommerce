package com.springboot.ecommerce.common.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginationParam
{
    private Integer page = 0;

    private Integer limit = 20;
}
