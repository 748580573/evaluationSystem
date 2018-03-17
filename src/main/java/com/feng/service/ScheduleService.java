package com.feng.service;

import com.feng.bean.Schedule;
import com.feng.mapper.ScheduleMapper;
import com.feng.tool.SessionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ScheduleService {
    private SqlSession session =  null;
    private ScheduleMapper scheduleMapper  = null;

    /**
     *
     * @param clazzNumber
     * @return       获取该班课表
     */
    public List<Schedule> selectAllSchedule(String clazzNumber){
        session = SessionFactory.getSqlSession();
        scheduleMapper = session.getMapper(ScheduleMapper.class);
        List<Schedule> list  = scheduleMapper.selectAllSchedule(clazzNumber);
        session.commit();
        System.out.println("课表查询结束");
        return list;
    }

    /**
     *
     * @param schedule
     * @return    课程添加
     */
    public int scheduleAdd(Schedule schedule){
        int isOK = 0;
        session = SessionFactory.getSqlSession();
        ScheduleMapper scheduleMapper = session.getMapper(ScheduleMapper.class);
        if (scheduleMapper.selectScheduleByDate(schedule.getPeriod(),schedule.getWeeks(),schedule.getOrders()) != null){
            return isOK;
        }
        isOK = scheduleMapper.scheduleAdd(schedule);
        ClazzAndTeacherMapperService clazzAndTeacherMapperService = new ClazzAndTeacherMapperService();
        isOK = clazzAndTeacherMapperService.assosicateClazzAndTeacher(schedule.getClazzNumber(),schedule.getTeacherNumber());// 将教师与班级进行关联
        session.commit();
        return isOK;
    }

    /**
     *
     * @param schedule
     * @return   根据日期选择日期
     */
    public Schedule selectScheduleByDate(Schedule schedule){
        session = SessionFactory.getSqlSession();
        scheduleMapper = session.getMapper(ScheduleMapper.class);
        Schedule schedule1 = scheduleMapper.selectScheduleByDate(schedule.getWeeks(),schedule.getOrders(),schedule.getPeriod());
        session.commit();
        return schedule1;
    }

    /**
     *
     * @param clazzNumber        班级号
     * @param period             学期
     * @return
     */
    public List<Schedule> selectScheduleByClazzNumberAndPeriod(String clazzNumber,String period){
        session = SessionFactory.getSqlSession();
        scheduleMapper = session.getMapper(ScheduleMapper.class);
        List<Schedule> list = scheduleMapper.selectScheduleByClazzNumberAndPeriod(clazzNumber,period);
        session.commit();
        return list;
    }

    /**
     *
     * @param teacherNumber
     * @param clazzNumber
     * @return   根据班级号和教师号查找课程
     */
    public Schedule selectScheduleByTeacherNumberAndClazzNumber( String teacherNumber,String clazzNumber){
        session = SessionFactory.getSqlSession();
        scheduleMapper = session.getMapper(ScheduleMapper.class);
        Schedule schedule = scheduleMapper.selectScheduleByTeacherNumberAndClazzNumber(teacherNumber, clazzNumber);
        session.commit();
        return schedule;
    }

}
