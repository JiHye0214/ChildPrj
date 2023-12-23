package com.project.childprj.service;

import com.project.childprj.domain.ChildHouse;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import java.util.List;

public interface ChildHouseService {
    // 어린이집 데이터 1개 추가
    int insertChildHouse(ChildHouse childHouse);

    // 어린이집 api 결과 데이터 저장 동작
    ResponseEntity<Integer> saveChildHouse(Integer startIndex, Integer endIndex);

    // 어린이집 페이징 목록 조회
    List<ChildHouse> childHouseList(Integer page, String type, Model model);

    // 특정 id 어린이집 조회
    ChildHouse getChildHouse(Long id);
}
