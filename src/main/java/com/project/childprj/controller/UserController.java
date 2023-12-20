package com.project.childprj.controller;

import com.project.childprj.domain.User;
import com.project.childprj.domain.UserValidator;
import com.project.childprj.service.UserService;
import com.project.childprj.util.U;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    // Autowired / GetMapping(RequestMapping) / PostMapping 구분해 놓기!
    // PostMapping 주석 간단 설명

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/zzim")
    public void togetherZzim(HttpServletRequest request){
    }

    @GetMapping("/logIn")
    public void logIn(){};

    @GetMapping("/signUp")
    public void signUp(){};

    @GetMapping("/mypage")
    public void mypage(){
        System.out.println(U.getLoggedUser().getPassword());
    }

    @GetMapping("/signUpAgree")
    public void signUpAgree(){
    }

    @GetMapping("/find")
    public void find(){
    }

    // 로그인
    @PostMapping("/logIn")
    public void logInPost(){};

    // 로그인 에러
    @PostMapping("/loginError")
    public String loginError(){
        return "user/login";
    }

    // 회원가입
    @PostMapping("/signUp")
    public String signUp(@Valid User user,
                         BindingResult result,
                         Model model,
                         RedirectAttributes redirectAttributes) {

        // 검증 에러가 있으면 redirect
        if(result.hasErrors()){
            redirectAttributes.addFlashAttribute("loginId", user.getLoginId());
            redirectAttributes.addFlashAttribute("email", user.getEmail());
            redirectAttributes.addFlashAttribute("nickname", user.getNickname());
            redirectAttributes.addFlashAttribute("password", user.getNickname());
            redirectAttributes.addFlashAttribute("name", user.getNickname());

            List<FieldError> errList = result.getFieldErrors();
            for(FieldError err : errList){
                redirectAttributes.addFlashAttribute("error_" + err.getField(), err.getCode());
            }

            return "redirect:/user/signUp";
        }

        int resister = userService.signUp(user);
        model.addAttribute("result", resister);
        return "/user/signUpOk";
    }

    // 닉네임 변경
    @PostMapping("/nickname")
    public String fixNickname(User user, Model model){

        U.getLoggedUser().setNickname(user.getNickname());
        model.addAttribute("change", userService.modifyNickname(user));
        return "/user/changeOk";
    }

    // 비번 변경
    @PostMapping("/password")
    public String fixPassword(User user, Model model){

        model.addAttribute("change", userService.modifyPassword(user));
        return "/user/changeOk";
    }

    // 회원 탈퇴
    @PostMapping("/drop")
    public String dropUser(User user, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {

        // 회원 탈퇴 후 로그아웃
        // 성공 !!
        if(passwordEncoder.matches(user.getPassword(), U.getLoggedUser().getPassword())){ // 비번 맞으면
            Authentication auth = SecurityContextHolder.getContext().getAuthentication(); // 근데 이게 머지 인증 가져오기?
            if (auth != null) {
                model.addAttribute("delete", userService.dropUser(user));
                new SecurityContextLogoutHandler().logout(request, response, auth); // 시큐리티 여기서도 되네
            }
            return "redirect:/home";
        }
        return "/user/dropFail";
    }

// ------------------validator--------------------

    @Autowired
    UserValidator userValidator;

    @InitBinder
    public void intiBinder(WebDataBinder binder) {

        binder.setValidator(userValidator);
    }
}
