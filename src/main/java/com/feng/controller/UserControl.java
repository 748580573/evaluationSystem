package com.feng.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.feng.bean.User;
import com.feng.service.UserService;
import com.feng.tool.UserInfo;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserControl {
    private UserService userService = null;
    private User user;
    @Autowired
    HttpServletRequest request;


    @RequestMapping(value = "/userLogin",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String userLogin(@RequestParam(value = "account",required = false) String account,@RequestParam(value = "password",required = false) String password) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        HttpSession session = request.getSession();
        userService = new UserService();
        user = userService.loginUser(account);
        if (user != null){
            if (user.getPassword().equals(password)){
                UserInfo.setUserInfo(account,user);
            }
        }else{
            return "{\"flag\":\"0\"}";
        }
        session.setAttribute("account",account);
        String json = objectMapper.writeValueAsString(user);
        return json;
    }
}
