package com.sun.springboothello.java.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;

/**
 * @author sun.yang
 * @version 1.0
 * @description: TODO
 * @date 2025/8/29 17:01
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        String requestUri = request.getRequestURI();
        HttpSession session = request.getSession(false); // 不自动创建新session

        logger.info("请求路径: {}, Session ID: {}", requestUri,
                session != null ? session.getId() : "null");

        // 公开路径
        if (isPublicPath(requestUri)) {
            return true;
        }

        // 检查登录状态
        if (session == null || session.getAttribute("username") == null) {
            logger.warn("未登录访问受保护路径: {}", requestUri);
            response.sendRedirect("/login?error="+URLEncoder.encode("请先登录","utf-8"));
            return false;
        }

        return true;
    }

    private boolean isPublicPath(String requestUri) {
        return requestUri.equals("/") ||
                requestUri.equals("/login") ||
                requestUri.equals("/logout") ||
                requestUri.equals("/error") ||
                requestUri.startsWith("/css/") ||
                requestUri.startsWith("/js/") ||
                requestUri.startsWith("/images/") ||
                requestUri.equals("/favicon.ico");
    }
}
