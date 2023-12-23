package com.project.childprj.repository;

import com.project.childprj.domain.UserImg;
import org.springframework.stereotype.Repository;

@Repository
public interface UserImgRepository {

    // 특정 user의 img 불러오기
    UserImg findUserImg(Long userId);

    // 프사 넣기
    int imgInsert(UserImg userImg);

    // 이전 이미지 DB 삭제
    int imgDelete(Long userId);

}
