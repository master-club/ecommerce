package com.springboot.ecommerce.repository;

import com.springboot.ecommerce.entity.Category;
import com.springboot.ecommerce.repository.query.CategoryQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long>
{
    @Query(CategoryQuery.FIND_ALL)
    Page<Category> findAll(Pageable pageable);

    @Query(CategoryQuery.FIND_BY_ID)
    Optional<Category> findById(@Param("id") Long id);

    @Modifying
    @Query(CategoryQuery.DELETE_BY_ID)
    void deleteById(@Param("id") Long id);
}
