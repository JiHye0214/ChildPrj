package com.project.childprj.repository;

import com.project.childprj.domain.ChildHouse;
import com.project.childprj.domain.Kindergarden;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChildHouseRepository {
    // 어린이집 데이터 1개 추가
    int insertChildHouse(ChildHouse childHouse);

    // from 부터 cnts 개 글 조회
    List<ChildHouse> selectFromCnt(int from, int cnts);

    // 전체 글 개수 조회
    int selectCountAll();

    // 특정 id 어린이집 조회
    ChildHouse selectChildHouse(Long id);

    // 전체 불러오기
    List<ChildHouse> selectAll();
}
