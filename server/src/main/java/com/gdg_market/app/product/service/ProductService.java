package com.gdg_market.app.product.service;

import com.gdg_market.app.product.dto.ProductRequestDTO;
import com.gdg_market.app.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Page<Product> getAllProducts(Pageable pageable);
    Product getProductById(Long id);
    Product createProduct(ProductRequestDTO productRequestDTO);
    Product updateProduct(Long id, ProductRequestDTO productRequestDTO);
    void deleteProductById(Long id);
}
