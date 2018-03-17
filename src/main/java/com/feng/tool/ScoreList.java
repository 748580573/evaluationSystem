package com.feng.tool;

import com.feng.bean.Clazz;
import com.feng.bean.Schedule;
import com.feng.bean.Score;
import com.feng.bean.Student;
import com.feng.service.ClazzService;
import com.feng.service.ScheduleService;

import java.util.ArrayList;
import java.util.List;

public class ScoreList {
    public List<Score> getScoreListByClassAndSchedule(String major,String grade,String orders,String teacherNumber){
        ClazzService clazzService = new ClazzService();
        ScheduleService scheduleService = new ScheduleService();
        List<Score> list = new ArrayList<Score>();

        Clazz clazz = clazzService.selectClazzByName(major,grade,orders);
        List<Student> studentList = clazz.getStudentList();

        Schedule schedule = scheduleService.selectScheduleByTeacherNumberAndClazzNumber(teacherNumber,clazz.getNumber());

        for (Student student : studentList){
            Score score = new Score();
            score.setType(schedule.getType());                     //设置课程类型
            score.setClazzNumber(clazz.getNumber());               //设置班级编号
            score.setCourseNumber(schedule.getCourseNumber());     //设置课程编号
            score.setTeacher(schedule.getTeacher());              //设置教师
            score.setName(schedule.getClazzName());               //设置课程名
            score.setStudentNumber(student.getNumber());          //设置学生编号
            score.setStudentName(student.getName());              //设置学生名
            score.setCredit(schedule.getCredit());                //设置学分
            score.setPeriod(schedule.getPeriod());                //设置学期
            list.add(score);
        }
        return list;
    }
}
