package com.feng.tool;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularUtil {
    private Pattern pattern = null;
    Matcher matcher = null;
    private String  regular;                  //正则表达式

    /**
     *
     * @param score  检验成绩格式
     * @return
     */
    public boolean CheckScore(String score){
        regular = "\\d{1,3}";
        pattern = Pattern.compile(regular);
        matcher = pattern.matcher(score);
        return matcher.matches();
    }

    //检验学生账号格式
    public boolean CheckStudnetAccount(String studentAccount){
        regular = "(\\d{4})(\\d{2})(\\d{3})(\\d)(\\d{2})";
        pattern = Pattern.compile(regular);
        matcher = pattern.matcher(studentAccount);
        return matcher.matches();
    }

    public boolean CheckTeacherAccount(String teacherAccount){
        regular = "(\\d{4})(\\d{2})(\\d{2})(\\d{2,3})";
        pattern = Pattern.compile(regular);
        matcher = pattern.matcher(teacherAccount);
        return matcher.matches();
    }
}
