package com.project.childprj.config;

import com.project.childprj.domain.User;
import com.project.childprj.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserInformation implements UserDetails {

    private UserService userService;

    public void setUserService (UserService userService) {this.userService = userService;}

    private User user;

    public User getUser (){ return user; }

    public UserInformation (User user){
        System.out.println("UserInformation is called() -- " + user);
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getLoginId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
