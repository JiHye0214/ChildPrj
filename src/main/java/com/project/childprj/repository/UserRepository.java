package com.project.childprj.repository;

import com.project.childprj.domain.User;
import com.project.childprj.domain.UserImg;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    // 아이디(increment)로 유저 찾기
    User findUserById(Long id);

    // 회원가입 - 회원 등록
    int newUser(User user);

    // 회원가입 - 아이디 중복
    User findUserByLogId(String loginId);

    // 회원가입 - 닉네임 중복
    User findUserByNickname(String nickname);

    // 회원가입 - 이메일 중복
    User findUserByEmail(String email);

    // 찾기 - 아이디 & 비번 (이름, 이메일)
    User findIdPwByEmail(String name, String email);

    // 찾기 - 비번 (아이디)
    User findPwById(String name, String loginId);

    // 마이페이지 - 닉네임 변경
    int fixNickname(User user);

    // 마이페이지 - 비번 변경
    int fixPassword(User user);

    // 마이페이지 - 회원 탈퇴
    int dropUser(User user);

}
