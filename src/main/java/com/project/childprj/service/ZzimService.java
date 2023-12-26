package com.project.childprj.service;

import com.project.childprj.domain.Zzim;
import org.springframework.ui.Model;

import java.util.List;

public interface ZzimService {
    // 찜리스트 페이징 목록 조회
    List<Zzim> zzimList(Integer page, Model model);

    // 찜 클릭 여부
    boolean isZzimChecked(Long userId, Long togetherId);

    // 찜 추가
    int insertZzim(Long userId, Long togetherId, String type);

    // 찜 취소
    int deleteZzim(Long userId, Long togetherId);
}
