package com.feng.tool;

import com.feng.bean.User;

import java.util.HashMap;
import java.util.Map;

public class UserInfo {
    private static Map<String,User> userInfo = new HashMap<String, User>();

    public static User getUserInfo(String account) {
        return userInfo.get(account);
    }

    public static void setUserInfo(String account,User user) {
        userInfo.put(account,user);
    }
}
