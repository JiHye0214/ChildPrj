package com.project.childprj.repository;

import com.project.childprj.domain.UserImg;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserImgRepository {

    // 특정 user의 img 불러오기
    UserImg findByUserId(Long loginId);

    // 프사 변경?
    int imgInsert(UserImg userImg);

    // 이전 이미지 DB 삭제
    int imgDelete(UserImg userImg);

}
