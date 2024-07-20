package com.gdg_market.app.product.service;

import com.gdg_market.app.product.dto.CategoryRequestDTO;
import com.gdg_market.app.product.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface CategoryService {
    Page<Category> getAllCategories(Pageable pageable);
    Category getCategoryById(Long id);
    Category createCategory(CategoryRequestDTO categoryRequestDTO);
    void deleteCategoryById(Long id);
    Category updateCategory(Long id, CategoryRequestDTO categoryRequestDTO);
}
