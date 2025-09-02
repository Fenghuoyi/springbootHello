package com.sun.springboothello.java.entity;

import javax.validation.constraints.NotBlank;

/**
 * @author sun.yang
 * @version 1.0
 * @description: TODO
 * @date 2025/8/29 16:36
 */
public class LoginForm {

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    // 构造器
    public LoginForm() {}

    public LoginForm(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter和Setter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}