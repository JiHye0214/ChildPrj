package com.project.childprj.config;

import com.lec.spring.config.LoginFailure;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.io.IOException;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    // password Encoder
    @Bean
    public
    PasswordEncoder encoder(){
        System.out.println("PasswordEncoder bean is created");
        return new BCryptPasswordEncoder();
    }

    // security setting
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable()) // CSRF 비활성화

                // authority setting
                .authorizeHttpRequests(auth -> auth
                        // 로그인만 하면 들어갈 수 있도록 !
                        .requestMatchers("/user/signIn").authenticated()
                        .requestMatchers("/post/detail/*").authenticated()
                        .requestMatchers("/post/write").authenticated()
                        .requestMatchers("/product/detail/*").authenticated()
                        .requestMatchers("/product/write").authenticated()
                        .requestMatchers("/user/mypage").authenticated()
                        .requestMatchers("/user/zzim").authenticated()
                        .anyRequest().permitAll()
                )

                // login setting
                // ⭐⭐⭐⭐⭐ DB에서 password가 암호화 되어 있지 않으면 Spring Security의 로그인 기능을 이용할 수 없다니!!!
                .formLogin(form -> {
                            form
                                    .usernameParameter("loginId") // loadUserByUserName() 매개변수 username을 loginId로 바꾸기
                                    .loginPage("/user/logIn")
                                    .loginProcessingUrl("/user/logIn")
                                    .successHandler(new LoginSuccess("/home"))
                                    .failureHandler(new LoginFailure());
                        }
                )

                // logout setting
                .logout(httpSecurityLogoutConfigurer -> httpSecurityLogoutConfigurer
                        .logoutUrl("/doLogout") // 근데 이런 거 없는데..?
                        .logoutSuccessUrl("/home")
                        .invalidateHttpSession(false) // 이게 머지
//                        .logoutSuccessHandler(new LogoutSuccess())
                )

                // exception
                .exceptionHandling(httpSecurityExceptionHandlingConfigurer -> httpSecurityExceptionHandlingConfigurer
                        .accessDeniedHandler(new AccessDeniedHandler1())
                )
//
                .build();
    }
}
