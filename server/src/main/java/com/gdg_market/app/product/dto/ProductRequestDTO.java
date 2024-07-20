package com.gdg_market.app.product.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {
    private String name; // 상품명
    private String imageURL; // 이미지 URL
    private long price; // 가격
    private String description; // 설명
}
