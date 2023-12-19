package com.project.childprj.repository;

import com.project.childprj.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    // 아이디(increment)로 정보 찾기
    User findUserById(Long id);

    // 아이디(loginId)로 정보 찾기
    User findUserByLogId(String loginId);

    // 아이디(loginId)로 정보 찾기
    User findUserByNickname(String nickname);

    User findUserByEmail(String email);

    // 회원 등록
    int newUser(User user);

    // 정보 수정
    int fixNickname(User user);
    int fixPassword(User user);

    // 회원 탈퇴
    int dropUser(User user);
}
