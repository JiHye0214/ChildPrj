package com.project.childprj.service;

import com.project.childprj.domain.User;
import com.project.childprj.domain.UserImg;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface UserService {

    // 아이디(loginId)로 정보 찾기
    User findByLogId(String loginId);

    // 회원가입 - 등록된 아이디(loginId)인지 확인
    boolean isExistId(String loginId);

    // 회원가입 - 등록된 닉네임인지 확인
    boolean isExistNn(String nickname);

    // 회원가입 - 등록된 이메일인지 확인
    boolean isExistEm(String email);

    // 회원가입 - 회원 등록
    int signUp(User user);

    // 찾기 - 아이디 & 비번 (이름, 이메일)
    boolean findIdPwByEmail(String name, String email);

    // 찾기 - 아이디 보여주기
    User userIdIs(String email);

    // 찾기 - 비번 (아이디)
    boolean findPwById(String name, String loginId);

    // 마이페이지 - 닉네임 수정
    int modifyNickname(User user);

    // 마이페이지 - 비번 수정
    int modifyPassword(User user);

    // 마이페이지 - 회원 탈퇴
    int dropUser(User user);

    // 마이페이지 - 특정 user의 img 불러오기
    UserImg findUserImg (Long userId);

    // 마이페이지 - 프사 등록
    boolean insertImg (Map<String, MultipartFile> files);

}
