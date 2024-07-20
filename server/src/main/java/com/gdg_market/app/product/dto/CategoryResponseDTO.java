package com.gdg_market.app.product.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
public class CategoryResponseDTO {
    private Long id; // 카테고리 ID

    private String name; // 카테고리명
    private Long parentId; // 상위 카테고리 ID
    private Set<Long> childrenIds; // 하위 카테고리 ID 목록

    private LocalDateTime createdAt; // 생성일시
    private LocalDateTime modifiedAt; // 수정일시
}
