package com.gdg_market.app.part_time.service;

import com.gdg_market.app.part_time.dto.RecruitPostRequestDTO;
import com.gdg_market.app.part_time.model.RecruitPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RecruitPostService {
    Page<RecruitPost> getAllRecruitPosts(Pageable pageable);
    RecruitPost getRecruitPostById(Long id);
    RecruitPost createRecruitPost(RecruitPostRequestDTO recruitPostRequestDTO);
    RecruitPost updateRecruitPost(Long id, RecruitPostRequestDTO recruitPostRequestDTO);
    void deleteRecruitPostById(Long id);
}