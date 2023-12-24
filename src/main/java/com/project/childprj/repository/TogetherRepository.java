package com.project.childprj.repository;

import com.project.childprj.domain.Together;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TogetherRepository {
    // 함께하기 데이터 1개 추가
    int insertTogether(Together together);

    // 체험 or 축제 from 부터 cnts 개 글 조회
    List<Together> selectType12FromCnt(int from, int cnts, String type);

    // 공연ㆍ예술 from 부터 cnts 개 글 조회
    List<Together> selectType3FromCnt(int from, int cnts);

    // 체험 or 축제 글 개수 조회
    int selectCountType12(String type);

    // 공연ㆍ예술 글 개수 조회
    int selectCountType3();

    // 특정 id 함께하기 조회
    Together selectTogether(Long id);
}
