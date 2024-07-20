package com.gdg_market.app.product.repository;

import com.gdg_market.app.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
