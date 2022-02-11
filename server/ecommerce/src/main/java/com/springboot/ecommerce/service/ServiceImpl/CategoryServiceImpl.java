package com.springboot.ecommerce.service.ServiceImpl;

import com.springboot.ecommerce.common.domain.PaginationParam;
import com.springboot.ecommerce.common.domain.ResultSet;
import com.springboot.ecommerce.common.exception.ResourceNotFoundException;
import com.springboot.ecommerce.common.exception.UnexpectedPhantomReadCommonException;
import com.springboot.ecommerce.entity.Category;
import com.springboot.ecommerce.repository.CategoryRepository;
import com.springboot.ecommerce.repository.sort.CategorySort;
import com.springboot.ecommerce.resource.CategoryResource;
import com.springboot.ecommerce.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CategoryServiceImpl implements CategoryService
{
    private final CategoryRepository categoryRepository;

    @Override
    @Transactional(readOnly = true)
    public ResultSet<CategoryResource> getCategoryResourceList(PaginationParam pagination, CategorySort sort) {
        Pageable pageable = PageRequest.of(pagination.getPage(), pagination.getLimit(),
                Sort.by(sort.getDirection(), sort.getSortBy().getPropertyName()));
        Page<Category> resultSet = categoryRepository.findAll(pageable);
        List<CategoryResource> resources = convertEntitiesToResources(resultSet.getContent());
        return new ResultSet<>(resources, resultSet.getTotalElements());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CategoryResource> getCategoryResource(Long id) {
        return categoryRepository.findById(id).map(this::convertEntityToResource);
    }

    @Override
    @Transactional
    public CategoryResource createCategoryResource(CategoryResource categoryResource) {
        Long id = categoryRepository.save(categoryResource.toBuilder()
                .isDeleted(false)
                .build()
                .toEntity()).getId();
        return getCategoryResource(id).orElseThrow((UnexpectedPhantomReadCommonException::new));
    }

    @Override
    @Transactional
    public CategoryResource updateCategoryResource(Long id, CategoryResource categoryResource) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(CategoryResource.class, id));
        categoryRepository.save(categoryResource.toBuilder()
                .createAt(category.getCreatedAt())
                .isDeleted(category.isDeleted())
                .build()
                .toEntity().withId(id));
        return getCategoryResource(id).orElseThrow((UnexpectedPhantomReadCommonException::new));
    }

    @Override
    @Transactional
    public void deleteCategoryResource(Long id) {
        categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(CategoryResource.class, id));
        categoryRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public CategoryResource convertEntityToResource(Category entity) {
        return convertEntitiesToResources(Collections.singletonList(entity)).get(0);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryResource> convertEntitiesToResources(List<Category> entities) {
        return entities.stream()
                .map(CategoryResource::new)
                .collect(toList());
    }
}
