package com.feng.bean;

public class User {
    private String number;                    //用户账号，这里指用户的编号
    private String password;                  //用户密码
    private String type;                      //用户类型
    private int isExist;                      //用户是否删除

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIsExist() {
        return isExist;
    }

    public void setIsExist(int isExist) {
        this.isExist = isExist;
    }
}
