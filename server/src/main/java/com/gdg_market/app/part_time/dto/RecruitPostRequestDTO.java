package com.gdg_market.app.part_time.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecruitPostRequestDTO {
    private String title; // 제목
    private String content; // 내용
    private String workTime; // 근무 시간
    private long hourlyWage; // 시급
    private String location; // 위치
}
