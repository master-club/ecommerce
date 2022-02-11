package com.springboot.ecommerce.repository.query;

public class CategoryQuery
{
    public static final String FIND_ALL = "select c from Category c where c.isDeleted = false";

    public static final String FIND_BY_ID = "select c from Category c where c.id = :id and c.isDeleted = false";

    public static final String DELETE_BY_ID = "update Category c set c.isDeleted = true where c.id = :id";
}
