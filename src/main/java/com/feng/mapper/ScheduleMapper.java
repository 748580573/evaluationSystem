package com.feng.mapper;

import com.feng.bean.Schedule;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ScheduleMapper {

    /**
     *
     * @param clazzNumber
     * @return    查询所有与该班级有关的课程
     */
    @Select("select * from schedule where clazzNumber = #{clazzNumber} and period = #{period}")
    @Results({
            @Result(column = "clazzNumber",property = "clazzNumber"),
            @Result(column = "courseNumber",property = "courseNumber"),
            @Result(column = "clazzName",property = "clazzName"),
            @Result(column = "location",property = "location"),
            @Result(column = "teacher",property = "teacher"),
            @Result(column = "teacherNumber",property = "teacherNumber"),
            @Result(column = "period",property = "period"),
            @Result(column = "credit",property = "credit"),
            @Result(column = "weeks",property = "weeks"),
            @Result(column = "orders",property = "orders"),
            @Result(column = "type",property = "type")
    })
    List<Schedule> selectAllSchedule(@Param("clazzNumber") String clazzNumber,@Param("period") String period);


    /**
     *
     * @param period
     * @param weeks
     * @param orders
     * @return 根据时间查询课程
     */
    @Select("select * from schedule where weeks = #{weeks} and orders = #{orders} and period = #{period}")
    @Results({
            @Result(column = "clazzNumber",property = "clazzNumber"),
            @Result(column = "courseNumber",property = "courseNumber"),
            @Result(column = "clazzName",property = "clazzName"),
            @Result(column = "location",property = "location"),
            @Result(column = "teacher",property = "teacher"),
            @Result(column = "teacherNumber",property = "teacherNumber"),
            @Result(column = "period",property = "period"),
            @Result(column = "credit",property = "credit"),
            @Result(column = "weeks",property = "weeks"),
            @Result(column = "orders",property = "orders"),
            @Result(column = "type",property = "type")
    })
    Schedule selectScheduleByDate(@Param("period") String period,@Param("weeks") String weeks,@Param("orders") String orders);

    /**
     *
     * @param schedule
     * @return   添加课程
     */
    @Insert("insert into schedule(clazzNumber,courseNumber,clazzName,location,teacher,teacherNumber,period,credit,weeks,orders,type)" +
            " values(#{clazzNumber},#{courseNumber},#{clazzName},#{location},#{teacher},#{teacherNumber},#{period},#{credit},#{weeks},#{orders},#{type})")
    int scheduleAdd(Schedule schedule);

    /**
     *
     * @param clazzNumber
     * @param period
     * @return   查询某一班级某一学期的课程
     */
    @Select("select * from schedule where clazzNumber = #{clazzNumber} and period = #{period}")
    @Results({
            @Result(column = "clazzNumber",property = "clazzNumber"),
            @Result(column = "courseNumber",property = "courseNumber"),
            @Result(column = "clazzName",property = "clazzName"),
            @Result(column = "location",property = "location"),
            @Result(column = "teacher",property = "teacher"),
            @Result(column = "teacherNumber",property = "teacherNumber"),
            @Result(column = "period",property = "period"),
            @Result(column = "credit",property = "credit"),
            @Result(column = "weeks",property = "weeks"),
            @Result(column = "orders",property = "orders"),
            @Result(column = "type",property = "type")
    })
    List<Schedule> selectScheduleByClazzNumberAndPeriod(@Param("clazzNumber") String clazzNumber,@Param("period") String period);

    /**
     *
     * @param teacherNumber
     * @param clazzNumber
     * @return    根据班级号和教师号查找课程
     */
    @Select("select * from schedule where teacherNumber = #{teacherNumber} and clazzNumber = #{clazzNumber}")
    @Results({
            @Result(column = "clazzNumber",property = "clazzNumber"),
            @Result(column = "courseNumber",property = "courseNumber"),
            @Result(column = "clazzName",property = "clazzName"),
            @Result(column = "location",property = "location"),
            @Result(column = "teacher",property = "teacher"),
            @Result(column = "teacherNumber",property = "teacherNumber"),
            @Result(column = "period",property = "period"),
            @Result(column = "credit",property = "credit"),
            @Result(column = "weeks",property = "weeks"),
            @Result(column = "orders",property = "orders"),
            @Result(column = "type",property = "type")
    })
    Schedule selectScheduleByTeacherNumberAndClazzNumber(@Param("teacherNumber") String teacherNumber,@Param("clazzNumber") String clazzNumber);
}
