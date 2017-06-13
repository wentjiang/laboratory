package com.wentjiang.laboratory.controller;

import com.wentjiang.laboratory.util.CookieUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiangwentao on 2017/6/13 9:52.
 */
@Controller
@RequestMapping("/cookie")
public class CookieController {

    @ResponseBody
    @RequestMapping("/add")
    public Map<String, String> addCookie(String name,
                                         String value,
                                         HttpServletResponse response) {
        CookieUtil.addCookie(response, name, value, 3600);
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("value", value);
        return map;
    }

    @ResponseBody
    @RequestMapping("/get/{name}")
    public Map<String, String> getCookie(HttpServletRequest request, @PathVariable String name) {
        Cookie[] cookies = request.getCookies();
        Map<String, String> map = new HashMap<>();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name))
                    map.put(cookie.getName(), cookie.getValue());
            }
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/getAll")
    public Map<String, String> getCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        Map<String, String> map = new HashMap<>();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                map.put(cookie.getName(), cookie.getValue());
            }
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/remove/{name}")
    public String removeCookie(HttpServletRequest request, HttpServletResponse response, @PathVariable String name) {
        CookieUtil.removeCookie(request, response, name);
        String result = "remove cookie:" + name;
        return result;
    }

}
