package com.dl.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @author Li Lun
 * @date 2018/9/18 13:36
 * @description 请求拦截器
 */

@Slf4j
public class RequestInterceptor implements HandlerInterceptor {

    private static final String LOGIN_PATH = "/login";
    private static final String INDEX_PATH = "/index";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setCharacterEncoding("utf-8");
        String path = request.getServletPath();
        HttpSession httpSession = request.getSession();
        Object sessionData = httpSession.getAttribute("sessionData");

        if (LOGIN_PATH.equals(path) || INDEX_PATH.equals(path)) {
            return true;
        }

        if (!LOGIN_PATH.equals(path) && !INDEX_PATH.equals(path) && Objects.isNull(sessionData)) {
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // do nothing
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // do nothing
    }
}
