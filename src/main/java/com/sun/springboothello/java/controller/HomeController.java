package com.sun.springboothello.java.controller;

/**
 * @author sun.yang
 * @version 1.0
 * @description: TODO
 * @date 2025/8/29 17:07
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class HomeController {

    @Autowired
    private Environment environment;

    @GetMapping("/home")
    public String home(Model model, HttpSession session) {
        System.out.println(environment.getProperty("server.port"));
        // 拦截器已经处理了未登录情况，这里可以直接使用
        String username = (String) session.getAttribute("username");
        model.addAttribute("username", username);
        return "home";
    }
}
