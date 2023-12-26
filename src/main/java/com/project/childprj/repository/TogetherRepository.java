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

    // 함께하기 전체 조회
    List<Together> selectAllTogether();

    // 체험 or 축제 글 개수 조회
    int selectCountType12(String type);

    // 공연ㆍ예술 글 개수 조회
    int selectCountType3();

    // 함께하기 전체 개수 조회
    int countAllTogether();

    // 특정 id 함께하기 조회
    Together selectTogether(Long id);

    // 특정 id 함께하기 찜 카운트 변경 (찜 추가 시 num : 1 / 찜 해제 시 num : -1)
    int changeZzimCnt(Long num, Long id);

    // 특정 id 함께하기 찜 클릭 여부 변경 (찜 추가 시 bool : "true" / 찜 해제 시 bool : "false")
    int changeIsZzimClicked(String bool, Long id);

    // 전체 함께하기 찜 클릭 여부 "false" 로 변경
    int changeAllZzimClicked();
}
