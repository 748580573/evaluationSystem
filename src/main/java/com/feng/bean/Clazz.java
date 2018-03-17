package com.feng.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.List;
@JsonIgnoreProperties(value = "studentList")
public class Clazz {
    private String number;             //班级编号
    private String name;               //班级名
    private String academicSystem;     //学制
    private String major;              //专业
    private String grade;              //年纪
    private String orders;             //班级序号
    private List<Student> studentList; //该班含有的学生

    public String getOrders() {
        return orders;
    }

    public void setOrders(String orders) {
        this.orders = orders;
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

    public String getAcademicSystem() {
        return academicSystem;
    }

    public void setAcademicSystem(String academicSystem) {
        this.academicSystem = academicSystem;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
