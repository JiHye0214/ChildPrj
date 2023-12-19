package com.project.childprj.util;

import com.project.childprj.config.UserInformation;
import com.project.childprj.domain.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class U {


    // 현재 request 가져오기
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attrs.getRequest();
    }

    // 현재 로그인 한 사용자 User 구하기
    public static User getLoggedUser(){
        // 현재 로그인 한 사용자
        UserInformation userDetails = (UserInformation) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDetails.getUser();
        return user;
    }

    // 현재 session 구하기
    public static HttpSession getSession() {
        return getRequest().getSession();
    }

}
