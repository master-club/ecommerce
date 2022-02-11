package com.springboot.ecommerce.controller;

import com.springboot.ecommerce.common.domain.PaginationParam;
import com.springboot.ecommerce.common.domain.ResultSet;
import com.springboot.ecommerce.common.domain.SortParam;
import com.springboot.ecommerce.common.exception.ResourceNotFoundException;
import com.springboot.ecommerce.repository.sort.CategorySort;
import com.springboot.ecommerce.resource.CategoryResource;
import com.springboot.ecommerce.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.on;
import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.relativeTo;

@RestController
@Validated
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CategoryController
{
    private static final String RESOURCE_ID_HEADER = "Resource-Id";

    private static final String COLLECTION_RESOURCE_URI = "/categories";

    private static final String MEMBER_RESOURCE_URI = COLLECTION_RESOURCE_URI + "/{id}";

    private final CategoryService categoryService;

    @GetMapping(COLLECTION_RESOURCE_URI)
    public ResponseEntity<ResultSet<CategoryResource>> getCategoryResourceList(
            PaginationParam pagination,
            SortParam sort) {
        CategorySort categorySort = CategorySort.fromSort(sort);
        return ResponseEntity.ok(categoryService.getCategoryResourceList(pagination, categorySort));
    }

    @GetMapping(MEMBER_RESOURCE_URI)
    public ResponseEntity<CategoryResource> getCategoryResource(
            @PathVariable("id") Long id) {
        return categoryService.getCategoryResource(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException(CategoryResource.class, id));
    }

    @PostMapping(COLLECTION_RESOURCE_URI)
    public ResponseEntity<Void> createCategoryResource(
            @Valid @RequestBody CategoryResource categoryResource,
            UriComponentsBuilder uriBuilder) {
        Long id = categoryService.createCategoryResource(categoryResource).getId();
        URI uri = relativeTo(uriBuilder)
                .withMethodCall(on(getClass()).getCategoryResource(id))
                .build()
                .encode()
                .toUri();
        return ResponseEntity.created(uri)
                .header(RESOURCE_ID_HEADER, id.toString())
                .build();
    }

    @PutMapping(MEMBER_RESOURCE_URI)
    public ResponseEntity<CategoryResource> updateCategoryResource(
            @PathVariable("id") Long id,
            @Valid @RequestBody CategoryResource categoryResource) {
        CategoryResource updatedCategoryResource = categoryService.updateCategoryResource(id, categoryResource);
        return ResponseEntity.ok(updatedCategoryResource);
    }

    @DeleteMapping(MEMBER_RESOURCE_URI)
    public ResponseEntity<Void> deleteCategoryResource(
            @PathVariable("id") Long id) {
        categoryService.deleteCategoryResource(id);
        return ResponseEntity.noContent().build();
    }
}
