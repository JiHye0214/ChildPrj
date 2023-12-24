package com.project.childprj.repository;

import com.project.childprj.domain.Kindergarden;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KindergardenRepository {
    // 유치원 데이터 1개 추가
    int insertKindergarden(Kindergarden kindergarden);

    // from 부터 cnts 개 글 조회
    List<Kindergarden> selectFromCnt(int from, int cnts);

    // 전체 글 개수 조회
    int selectCountAll();

    // 특정 id 유치원 조회
    Kindergarden selectKindergarden(Long id);
}
