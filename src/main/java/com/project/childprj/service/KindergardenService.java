package com.project.childprj.service;

import com.project.childprj.domain.Kindergarden;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import java.util.List;

public interface KindergardenService {
    // 유치원 데이터 1개 추가
    int insertKindergarden(Kindergarden kindergarden);

    // 유치원 api 결과 데이터 저장 동작
    ResponseEntity<Integer> saveKindergarden(Integer startIndex, Integer endIndex);

    // 유치원 페이징 목록 조회
    List<Kindergarden> kindergardenList(Integer page, String type, Model model);

    // 특정 id 유치원 조회
    Kindergarden getKindergarden(Long id);

    // 전체 조회
    List<Kindergarden> selectAll();
}
