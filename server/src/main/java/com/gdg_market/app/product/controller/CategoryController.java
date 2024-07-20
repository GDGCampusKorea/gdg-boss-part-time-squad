package com.gdg_market.app.product.controller;

import com.gdg_market.app.bible.exception.InvalidRequestException;
import com.gdg_market.app.bible.exception.NotFoundException;
import com.gdg_market.app.product.dto.CategoryRequestDTO;
import com.gdg_market.app.product.dto.CategoryResponseDTO;
import com.gdg_market.app.product.model.Category;
import com.gdg_market.app.product.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/product-categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<Page<CategoryResponseDTO>> getAllCategories(Pageable pageable) {
        Page<Category> categories = categoryService.getAllCategories(pageable);
        Page<CategoryResponseDTO> responseDTOs = categories.map(this::convertToResponseDTO);
        return new ResponseEntity<>(responseDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> getCategory(@PathVariable Long id) {
        Category category = categoryService.getCategoryById(id);
        CategoryResponseDTO responseDTO = convertToResponseDTO(category);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CategoryRequestDTO categoryRequestDTO) {
        Category category = categoryService.createCategory(categoryRequestDTO);
        CategoryResponseDTO responseDTO = convertToResponseDTO(category);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> updateCategory(@PathVariable Long id, @RequestBody CategoryRequestDTO categoryRequestDTO) {
        Category category = categoryService.updateCategory(id, categoryRequestDTO);
        CategoryResponseDTO responseDTO = convertToResponseDTO(category);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategoryById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<String> handleInvalidRequestException(InvalidRequestException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    private CategoryResponseDTO convertToResponseDTO(Category category) {
        CategoryResponseDTO responseDTO = new CategoryResponseDTO();

        responseDTO.setId(category.getId());
        responseDTO.setName(category.getName());

        if (category.getParent() != null) {
            responseDTO.setParentId(category.getParent().getId());
        }

        responseDTO.setChildrenIds(category.getChildren().stream()
                .map(Category::getId)
                .collect(Collectors.toSet()));

        responseDTO.setCreatedAt(category.getCreatedAt());
        responseDTO.setModifiedAt(category.getModifiedAt());


        return responseDTO;
    }
}
