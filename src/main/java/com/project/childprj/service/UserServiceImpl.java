package com.project.childprj.service;

import com.project.childprj.domain.User;
import com.project.childprj.domain.UserImg;
import com.project.childprj.repository.UserImgRepository;
import com.project.childprj.repository.UserRepository;
import com.project.childprj.util.U;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Value("${app.upload.path}")
    private String uploadDir;

    // password Encoder
    @Autowired
    private PasswordEncoder passwordEncoder;

    UserImgRepository userImgRepository;
    UserRepository userRepository;

    // SqlSession : transaction 관리
    @Autowired
    public UserServiceImpl(SqlSession sqlSession){
        userImgRepository = sqlSession.getMapper(UserImgRepository.class);
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

    @Override
    public User userIdIs(String email) {
        return userRepository.findUserByEmail(email);
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

        // default img setting
        UserImg userImg = UserImg.builder()
                        .userId(user.getId())
                        .sourceName("default.jpg")
                        .fileName("default.jpg")
                        .build();

        userImgRepository.imgInsert(userImg);
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

    // 프사 조회
    @Override
    public UserImg findUserImg(Long userId) {
        return userImgRepository.findUserImg(userId);
    }

    // 프사 등록
    // * 등록과 동시에 원래 프사 삭제하기
    @Override
    public boolean insertImg(Map<String, MultipartFile> files) {

        Long userId = U.getLoggedUser().getId();
        changeImg(files, userId);

        return (files != null);
    }

    private void changeImg(Map<String, MultipartFile> files, Long userId) {

        // 프사 있으면 먼저 삭제
        if(userImgRepository.findUserImg(userId) != null){
            int result = userImgRepository.imgDelete(userId);
        }

        if(files == null) return; // 없으면 말고


        for(Map.Entry<String, MultipartFile> e : files.entrySet()){

            // 이름이 userImg 인 친구들만
            if(!e.getKey().startsWith("user")) continue;

            // 물리적 파일 저장
            UserImg profile = upload(e.getValue()); // 함수가 UserImg 타입을 반환

            if(profile != null) {
                profile.setUserId(userId);
                userImgRepository.imgInsert(profile);
            }
        }

    }

    private UserImg upload(MultipartFile multipartFile) {

        // 리턴할 객체 선언
        UserImg userImg = null;
        String sourceName = null;
        String fileName = null;

        String originalFilename = multipartFile.getOriginalFilename(); // 원본파일명

        // 초기화 눌렀을 때
        if(originalFilename.isEmpty()) {
            sourceName = "default.jpg";

            // 저장될 파일명
            fileName = sourceName; // 일단 같은 이름으로 저장

        } else {
            sourceName = StringUtils.cleanPath(originalFilename); // 경로 깨끗?

            // 저장될 파일명
            fileName = sourceName; // 일단 같은 이름으로 저장

            File file = new File(uploadDir, fileName); // 중복 확인

            if(file.exists()){  // 이미 존재하는 파일명,  중복된다면 다른 이름은 변경하여 파일 저장
                // a.txt => a_2378142783946.txt  : time stamp 값을 활용할 거다!
                // "a" => "a_2378142783946" : 확장자 없는 경우

                int pos = fileName.lastIndexOf(".");
                if(pos > -1){  // 확장자 있는 경우
                    String name = fileName.substring(0, pos);   // 파일 '이름'
                    String ext = fileName.substring(pos + 1);  // 파일 '확장자'

                    fileName = name + "_" + System.currentTimeMillis() + "." + ext;
                } else {  // 확장자 없는 경우
                    fileName += "_" + System.currentTimeMillis();
                }
            }

            // 파일 절대경로
            Path copyOfLocation = Paths.get(new File(uploadDir, fileName).getAbsolutePath());

            try {
                // inputStream을 가져와서
                // copyOfLocation (저장위치)로 파일을 쓴다.
                // copy의 옵션은 기존에 존재하면 REPLACE(대체한다), 오버라이딩 한다
                Files.copy(
                        multipartFile.getInputStream(),
                        copyOfLocation,
                        StandardCopyOption.REPLACE_EXISTING
                );
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        userImg = UserImg.builder()
                .sourceName(sourceName)
                .fileName(fileName)
                .build();

        return userImg;
    }

}





