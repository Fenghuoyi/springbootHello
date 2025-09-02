package com.sun.springboothello.java.controller;

import com.sun.springboothello.java.entity.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm(Model model, String error, HttpSession session) {
        // 检查是否已登录（使用现有session，不创建新session）
        if (session != null && session.getAttribute("username") != null) {
            return "redirect:/home";
        }

        model.addAttribute("loginForm", new LoginForm());
        if (error != null) {
            model.addAttribute("error", error);
        }
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@Valid LoginForm loginForm,
                               BindingResult result,
                               Model model,
                               HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        // 检查是否已登录
        if (session != null && session.getAttribute("username") != null) {
            return "redirect:/home";
        }

        if (result.hasErrors()) {
            return "login";
        }

        // 模拟登录验证
        if ("admin".equals(loginForm.getUsername()) && "123".equals(loginForm.getPassword())) {
            // 创建新session（如果不存在）并设置属性
            HttpSession newSession = request.getSession();
            newSession.setAttribute("username", loginForm.getUsername());
            newSession.setAttribute("loginTime", new Date());


            return "redirect:/home";
        } else {
            model.addAttribute("error", "用户名或密码错误");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            String username = (String) session.getAttribute("username");
            session.invalidate();  // 使session失效
        }
        return "redirect:/login?message=已成功退出登录";
    }
}
