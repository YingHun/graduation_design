package com.dl.config;

import com.dl.interceptor.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Li Lun
 * @date 2018/9/18 13:47
 * @description 注册拦截器
 */

@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    @Bean
    public HandlerInterceptor getHandlerInterceptor() {
        return new RequestInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/img/**", "/css/**", "/layui/**", "/js/**");
    }
}
