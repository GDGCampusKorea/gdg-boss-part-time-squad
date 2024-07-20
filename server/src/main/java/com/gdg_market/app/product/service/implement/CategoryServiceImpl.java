package com.gdg_market.app.product.service.implement;

import com.gdg_market.app.product.dto.CategoryRequestDTO;
import com.gdg_market.app.product.model.Category;
import com.gdg_market.app.product.repository.CategoryRepository;
import com.gdg_market.app.product.service.CategoryService;
import com.gdg_market.app.bible.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Page<Category> getAllCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Category not found"));
    }

    @Override
    public Category createCategory(CategoryRequestDTO categoryRequestDTO) {
        Category category = new Category();
        category.setName(categoryRequestDTO.getName());

        if (categoryRequestDTO.getParentId() != null) {
            Category parent = categoryRepository.findById(categoryRequestDTO.getParentId())
                    .orElseThrow(() -> new NotFoundException("Parent category not found"));
            category.setParent(parent);
        }

        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Category not found"));
        categoryRepository.delete(category);
    }

    @Override
    public Category updateCategory(Long id, CategoryRequestDTO categoryRequestDTO) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Category not found"));
        category.setName(categoryRequestDTO.getName());

        // 상위 카테고리 설정
        if (categoryRequestDTO.getParentId() != null) {
            Category parent = categoryRepository.findById(categoryRequestDTO.getParentId())
                    .orElseThrow(() -> new NotFoundException("Parent category not found"));
            category.setParent(parent);
        } else {
            category.setParent(null);
        }

        // 하위 카테고리 설정
        Set<Long> childrenIds = categoryRequestDTO.getChildrenIds();

        Set<Category> children = childrenIds.stream()
                .map(childId -> categoryRepository.findById(childId)
                        .orElseThrow(() -> new NotFoundException("Child category not found")))
                .collect(Collectors.toSet());

        // 기존 하위 카테고리와 업데이트된 하위 카테고리 설정
        category.getChildren().clear();
        category.getChildren().addAll(children);

        return categoryRepository.save(category);
    }
}
