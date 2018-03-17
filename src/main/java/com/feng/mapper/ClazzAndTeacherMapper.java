package com.feng.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface ClazzAndTeacherMapper {

    /**
     *
     * @param clazzNumber
     * @param teacherNumber
     * @return   将老师与班级进行关联
     */
    @Insert("insert into clazzAndTeacher(clazzNumber,teacherNumber) values(#{clazzNumber},#{teacherNumber})")
    int assosicateClazzAndTeacher(@Param("clazzNumber") String clazzNumber, @Param("teacherNumber") String teacherNumber);
}
