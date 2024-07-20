package com.gdg_market.app.part_time.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RecruitPostResponseDTO {
    private Long id; // 알바 모집 공고 ID

    private String title; // 제목
    private String content; // 내용
    private String workTime; // 근무 시간
    private long hourlyWage; // 시급
    private String location; // 위치

    private LocalDateTime createdAt; // 생성일시
    private LocalDateTime modifiedAt; // 수정일시
}
