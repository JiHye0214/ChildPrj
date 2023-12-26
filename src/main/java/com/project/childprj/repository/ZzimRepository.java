package com.project.childprj.repository;

import com.project.childprj.domain.Zzim;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZzimRepository {
    // user 별 from 부터 cnts 개 항목 조회
    List<Zzim> selectFromCnt(int from, int cnts, Long userId);

    // user 별 전체 항목 개수 조회
    int selectCountAll(Long userId);

    // 찜 클릭 여부
    Zzim zzimCheck(Long userId, Long togetherId);

    // 찜 추가
    int insertZzim(Zzim zzim);

    // 찜 취소
    int deleteZzim(Long userId, Long togetherId);

}
