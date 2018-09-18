package com.dl.config;

import com.dl.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @author Li Lun
 * @date 2018/9/18 14:04
 * @description 会话信息存储
 */

@Slf4j
public final class SessionStorageConfig {

    private static HttpSession httpSession;

    public static void storeSession(HttpServletRequest request, UserEntity userEntity) {
        if (checkSession(userEntity)) {
            httpSession = request.getSession();
        }

        httpSession.setAttribute(userEntity.getId().toString(), userEntity);
    }

    public static void clearSession(UserEntity userEntity) {
        String userId = userEntity.getId().toString();
        if (checkSession(userEntity)) {
            return;
        }

        httpSession.removeAttribute(userId);
    }

    private static boolean checkSession(UserEntity userEntity) {
        String userId = userEntity.getId().toString();
        if (null == httpSession) {
            log.warn("session may be null or empty!");
            return false;
        }

        if (Objects.isNull(httpSession.getAttribute(userId))) {
            log.warn("session not contains attribute {}!", userId);
            return false;
        }

        return true;
    }
}
