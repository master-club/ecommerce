package com.springboot.ecommerce.service;

import com.springboot.ecommerce.common.domain.PaginationParam;
import com.springboot.ecommerce.common.domain.ResultSet;
import com.springboot.ecommerce.entity.Category;
import com.springboot.ecommerce.repository.sort.CategorySort;
import com.springboot.ecommerce.resource.CategoryResource;

import java.util.List;
import java.util.Optional;

public interface CategoryService
{
    ResultSet<CategoryResource> getCategoryResourceList(PaginationParam pagination, CategorySort sort);

    Optional<CategoryResource> getCategoryResource(Long id);

    CategoryResource createCategoryResource(CategoryResource categoryResource);

    CategoryResource updateCategoryResource(Long id, CategoryResource categoryResource);

    void deleteCategoryResource(Long id);

    CategoryResource convertEntityToResource(Category entity);

    List<CategoryResource> convertEntitiesToResources(List<Category> entities);
}
