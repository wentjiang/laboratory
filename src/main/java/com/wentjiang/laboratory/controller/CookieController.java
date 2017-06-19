package com.wentjiang.laboratory.controller;

import com.wentjiang.laboratory.util.CookieUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${cookie.sign.key}")
    private String cookieKey;

    @ResponseBody
    @RequestMapping("/add")
    public Map<String, String> addCookie(String name,
                                         String value,
                                         HttpServletResponse response) {
        CookieUtil.addCookie(response, name, value, 3600);
        CookieUtil.addLBCookie(response, name + "LB", value + " LB", 3600);
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

    @ResponseBody
    @RequestMapping("/addMD5")
    public String addMD5Cookie(String name, String value, HttpServletResponse response) {
        String sign = DigestUtils.md5Hex(value + cookieKey);
        String result = value + "|" + sign;
        CookieUtil.addCookie(response, name, result, 3600);
        return "add cookie success name:" + name;
    }

    @ResponseBody
    @RequestMapping("/verifySign")
    public String verifySign(String name, HttpServletRequest request) {
        Cookie cookie = CookieUtil.getCookie(request, name);
        String value = cookie.getValue();
        String str = "|";
        String[] params = value.split(str);
        String param0 = params[0];
        String sign = params[1];
        String thisSign = DigestUtils.md5Hex(param0 + cookieKey);
        String result;
        if (thisSign.equals(sign)) {
            result = "sign verify pass";
        } else {
            result = "sign verify not pass";
        }
        return result;
    }

}
