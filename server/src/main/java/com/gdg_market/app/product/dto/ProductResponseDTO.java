package com.gdg_market.app.product.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProductResponseDTO {
    private Long id; // 상품 ID

    private String name; // 상품명
    private String imageURL; // 이미지 URL
    private long price; //
    private String description; // 설명

    private LocalDateTime createdAt; // 생성일시
    private LocalDateTime modifiedAt; // 수정일시
}
