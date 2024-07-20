package com.gdg_market.app.part_time.controller;

import com.gdg_market.app.bible.exception.InvalidRequestException;
import com.gdg_market.app.bible.exception.NotFoundException;
import com.gdg_market.app.part_time.dto.RecruitPostRequestDTO;
import com.gdg_market.app.part_time.dto.RecruitPostResponseDTO;
import com.gdg_market.app.part_time.model.RecruitPost;
import com.gdg_market.app.part_time.service.RecruitPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recruit-posts")
public class RecruitPostController {

    private final RecruitPostService recruitPostService;

    @Autowired
    public RecruitPostController(RecruitPostService recruitPostService) {
        this.recruitPostService = recruitPostService;
    }

    @GetMapping("/")
    public ResponseEntity<Page<RecruitPostResponseDTO>> getAllRecruitPosts(Pageable pageable) {
        Page<RecruitPost> recruitPosts = recruitPostService.getAllRecruitPosts(pageable);
        Page<RecruitPostResponseDTO> responseDTOs = recruitPosts.map(this::convertToResponseDTO);
        return new ResponseEntity<>(responseDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecruitPostResponseDTO> getRecruitPost(@PathVariable Long id) {
        RecruitPost recruitPost = recruitPostService.getRecruitPostById(id);
        RecruitPostResponseDTO responseDTO = convertToResponseDTO(recruitPost);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<RecruitPostResponseDTO> createRecruitPost(@RequestBody RecruitPostRequestDTO recruitPostRequestDTO) {
        RecruitPost recruitPost = recruitPostService.createRecruitPost(recruitPostRequestDTO);
        RecruitPostResponseDTO responseDTO = convertToResponseDTO(recruitPost);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecruitPostResponseDTO> updateRecruitPost(@PathVariable Long id, @RequestBody RecruitPostRequestDTO recruitPostRequestDTO) {
        RecruitPost recruitPost = recruitPostService.updateRecruitPost(id, recruitPostRequestDTO);
        RecruitPostResponseDTO responseDTO = convertToResponseDTO(recruitPost);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecruitPost(@PathVariable Long id) {
        recruitPostService.deleteRecruitPostById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<String> handleInvalidRequestException(InvalidRequestException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    private RecruitPostResponseDTO convertToResponseDTO(RecruitPost recruitPost) {
        RecruitPostResponseDTO responseDTO = new RecruitPostResponseDTO();

        responseDTO.setId(recruitPost.getId());
        responseDTO.setTitle(recruitPost.getTitle());
        responseDTO.setContent(recruitPost.getContent());
        responseDTO.setWorkTime(recruitPost.getWorkTime());
        responseDTO.setLocation(recruitPost.getLocation());
        responseDTO.setHourlyWage(recruitPost.getHourlyWage());

        responseDTO.setCreatedAt(recruitPost.getCreatedAt());
        responseDTO.setModifiedAt(recruitPost.getModifiedAt());
        return responseDTO;
    }
}
