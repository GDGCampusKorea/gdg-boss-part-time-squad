package com.gdg_market.app.product.repository;

import com.gdg_market.app.product.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
