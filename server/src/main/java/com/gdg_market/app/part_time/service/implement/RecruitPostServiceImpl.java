package com.gdg_market.app.part_time.service.implement;

import com.gdg_market.app.part_time.dto.RecruitPostRequestDTO;
import com.gdg_market.app.part_time.model.RecruitPost;
import com.gdg_market.app.part_time.repository.RecruitPostRepository;
import com.gdg_market.app.part_time.service.RecruitPostService;
import com.gdg_market.app.bible.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecruitPostServiceImpl implements RecruitPostService {
    private final RecruitPostRepository recruitPostRepository;


    @Override
    public Page<RecruitPost> getAllRecruitPosts(Pageable pageable) {
        return recruitPostRepository.findAll(pageable);
    }

    @Override
    public RecruitPost getRecruitPostById(Long id) {
        return recruitPostRepository.findById(id).orElseThrow(() -> new NotFoundException("Recruit post not found"));
    }

    @Override
    public RecruitPost createRecruitPost(RecruitPostRequestDTO recruitPostRequestDTO) {
        RecruitPost recruitPost = new RecruitPost();

        recruitPost.setTitle(recruitPostRequestDTO.getTitle());
        recruitPost.setContent(recruitPostRequestDTO.getContent());
        recruitPost.setWorkTime(recruitPostRequestDTO.getWorkTime());
        recruitPost.setHourlyWage(recruitPostRequestDTO.getHourlyWage());
        recruitPost.setLocation(recruitPostRequestDTO.getLocation());

        return recruitPostRepository.save(recruitPost);
    }

    @Override
    public RecruitPost updateRecruitPost(Long id, RecruitPostRequestDTO recruitPostRequestDTO) {
        RecruitPost recruitPost = recruitPostRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("RecruitPost not found"));

        recruitPost.setTitle(recruitPostRequestDTO.getTitle());
        recruitPost.setContent(recruitPostRequestDTO.getContent());
        recruitPost.setWorkTime(recruitPostRequestDTO.getWorkTime());
        recruitPost.setHourlyWage(recruitPostRequestDTO.getHourlyWage());
        recruitPost.setLocation(recruitPostRequestDTO.getLocation());

        return recruitPostRepository.save(recruitPost);
    }

    @Override
    public void deleteRecruitPostById(Long id) {
        RecruitPost recruitPost = recruitPostRepository.findById(id).orElseThrow
                (()-> new NotFoundException("Recruit post not found"));
        recruitPostRepository.delete(recruitPost);
    }
}
