package com.project.childprj.repository;

import com.project.childprj.domain.User;
import com.project.childprj.domain.UserAuthority;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAuthorityRepository {

    // 특정 이름의 권한 불러오기
    UserAuthority findAuthName(String authName);

    // 특정 유저한테 권한 주기
    int addAuthority(Long userId, Long authorityId);

    // 특정 유저 권한 이름 불러오기(우리는 어차피 유저당 권한 하나임)
    UserAuthority findByUser(Long userId);
}
