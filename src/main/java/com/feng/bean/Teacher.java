package com.feng.bean;

import java.util.List;

public class Teacher {
    private String number;                 //教工号
    private String name;                   //教师名称
    private String sex;                    //性别
    private String major;                  //专业
    private String institution;            //所属学院
    private String phone;                  //联系方式
    private List<Clazz>  clazzList;        //所教班级

    public List<Clazz> getClazzList() {
        return clazzList;
    }

    public void setClazzList(List<Clazz> clazzList) {
        this.clazzList = clazzList;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Teacher(){}
    public Teacher(String number,String name,String sex,String major,String institution,String phone){
        this.name = name;
        this.number = number;
        this.sex = sex;
        this.major = major;
        this.institution = institution;
        this.phone = phone;
    }
}
