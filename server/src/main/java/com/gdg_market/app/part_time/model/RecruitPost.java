package com.gdg_market.app.part_time.model;

import com.gdg_market.app.bible.model.BaseModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "part_time__recruit_posts")
public class RecruitPost extends BaseModel {
    @Column(name = "title", length = 256)
    private String title; // 제목

    @Column(name = "content", length = 2048)
    private String content; // 내용

    @Column(name = "work_time", length = 512)
    private String workTime; // 근무 시간

    @Column(name = "hourly_wage")
    private long hourlyWage; // 시급

    @Column(name = "location", length = 2048)
    private String location; // 위치
}
