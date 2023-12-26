package com.project.childprj.service;

import com.project.childprj.domain.Together;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import java.util.List;

public interface TogetherService {
    // 함께하기 데이터 1개 추가
    int insertTogether(Together together);

    // 함께하기 api 결과 데이터 저장 동작
    ResponseEntity<Integer> saveTogether(Integer startIndex, Integer endIndex);

    // 함께하기 페이징 목록 조회
    List<Together> togetherList(Integer page, String type, Model model);

    // 특정 id 함께하기 조회
    Together getTogether(Long id);


}
