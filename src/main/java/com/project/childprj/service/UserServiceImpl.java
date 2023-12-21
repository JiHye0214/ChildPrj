package com.project.childprj.service;

import com.project.childprj.domain.User;
import com.project.childprj.repository.UserRepository;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserServiceImpl implements UserService {

    // password Encoder
    @Autowired
    private PasswordEncoder passwordEncoder;

    UserRepository userRepository;

    // SqlSession : transaction 관리
    @Autowired
    public UserServiceImpl(SqlSession sqlSession){
        userRepository = sqlSession.getMapper(UserRepository.class); // repository/UserRepository --> 인터페이스는 만들었지만 구현하지 않음 --> sql이 만들어줌
        System.out.println("UserRepository is created()");
    }

    @Override
    public User findByLogId(String loginId) {
        return userRepository.findUserByLogId(loginId);
    }

    @Override
    public boolean isExistId(String loginId) {
        // 아이디로 정보 찾아서 있으면 true / 없으면 false
        User user = userRepository.findUserByLogId(loginId);
        return (user != null);
    }

    @Override
    public boolean isExistNn(String nickname) {
        User user = userRepository.findUserByNickname(nickname);
        return (user != null);
    }

    @Override
    public boolean isExistEm(String email) {
        User user = userRepository.findUserByEmail(email);
        return (user != null);
    }

    // 아이디 & 비번 찾기 (이름, 이메일)
    @Override
    public boolean findIdPwByEmail(String name, String email) {
        User user = userRepository.findIdPwByEmail(name, email);
        return (user != null);
    }

    // 비번 찾기 (이름, 아이디)
    @Override
    public boolean findPwById(String name, String loginId) {
        User user = userRepository.findPwById(name, loginId);
        return (user != null);
    }

    @Override
    public int signUp(User user) {
        // password encode
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.newUser(user);
        return 1;
    }

    @Override
    @Transactional
    public int modifyNickname(@RequestBody  User user) {
        int change = userRepository.fixNickname(user);
        return change;
    }

    @Override
    @Transactional
    public int modifyPassword(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        int change = userRepository.fixPassword(user);
        return change;
    }

    @Override
    public int dropUser(User user) {
        return userRepository.dropUser(user);
    }
}





