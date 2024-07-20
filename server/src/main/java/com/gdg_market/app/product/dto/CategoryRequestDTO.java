package com.gdg_market.app.product.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class CategoryRequestDTO {
    private String name; // 카테고리명
    private Long parentId; // 상위 카테고리
    private Set<Long> childrenIds = new HashSet<>();; // 하위 카테고리 ID 목록
}
