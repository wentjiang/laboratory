package com.wentjiang.laboratory.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jiangwentao on 2017/6/13 9:57.
 */
public class CookieUtil {

    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(maxAge);
        cookie.setDomain(".wentjiang.com");
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public static void removeCookie(HttpServletRequest request, HttpServletResponse response, String name) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(name)) {
                cookie.setHttpOnly(true);
                cookie.setMaxAge(0);
                cookie.setDomain(".wentjiang.com");
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }
    }
}
