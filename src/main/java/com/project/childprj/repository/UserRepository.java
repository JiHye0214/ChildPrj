package com.project.childprj.repository;

import com.project.childprj.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    // 아이디(increment)로 유저 찾기
    User findUserById(Long id);

    // 아이디(loginId)로 유저 찾기
    User findUserByLogId(String loginId);

    // 닉네임으로 정보 찾기
    User findUserByNickname(String nickname);

    // 이메일로 정보 찾기
    User findUserByEmail(String email);

    // 아이디 찾기 & 비번 찾기 (이름, 이메일)
    User findIdPwByEmail(String name, String email);

    // 비번 찾기 (아이디)
    User findPwById(String name, String loginId);

    // 회원 등록
    int newUser(User user);

    // 정보 수정
    int fixNickname(User user);
    int fixPassword(User user);

    // 회원 탈퇴
    int dropUser(User user);
}
