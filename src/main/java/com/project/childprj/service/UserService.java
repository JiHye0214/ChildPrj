package com.project.childprj.service;

import com.project.childprj.domain.User;

public interface UserService {

    // 아이디(loginId)로 정보 찾기
    User findByLogId(String loginId);

    // 등록된 아이디(loginId)인지 확인
    boolean isExistId(String loginId);

    // 등록된 닉네임인지 확인
    boolean isExistNn(String nickname);

    // 등록된 이메일인지 확인
    boolean isExistEm(String email);

    // 회원 등록
    int signUp(User user);

    // 닉네임 수정
    int modifyNickname(User user);

    // 비번 수정
    int modifyPassword(User user);

    // 비번 확인
    boolean confirmPw(User user, String password);

    // 회원 탈퇴
    int dropUser(User user);

}
