package com.feng.mapper;

import com.feng.bean.Clazz;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface ClazzMapper {

    /**
     *
     * @param number  班级号
     * @return   查找某一个班级的信息
     */
    @Select("select * from clazz where number = #{number}")
    @Results({
            @Result(column = "number",property = "number"),
            @Result(column = "name",property = "name"),
            @Result(column = "academicSystem",property = "academicSystem"),
            @Result(column = "major",property = "major"),
            @Result(column = "grade",property = "grade"),
            @Result(column = "orders",property = "orders"),
            @Result(column = "number",property = "studentList",
                    many = @Many(select = "com.feng.mapper.StudentMapper.selectStudentByClazzNumber",fetchType = FetchType.LAZY))

    })
    Clazz selectClazzByNumber(@Param("number") String number);

    /**
     *
     * @param major
     * @param grade
     * @param orders
     * @return  根据年级专业班级 查找班级
     */
    @Select("select * from clazz where major = #{major} and grade = #{grade} and orders = #{orders}")
    @Results({
            @Result(column = "number",property = "number"),
            @Result(column = "name",property = "name"),
            @Result(column = "academicSystem",property = "academicSystem"),
            @Result(column = "major",property = "major"),
            @Result(column = "grade",property = "grade"),
            @Result(column = "orders",property = "orders"),
            @Result(column = "number",property = "studentList",
                    many = @Many(select = "com.feng.mapper.StudentMapper.selectStudentByClazzNumber",fetchType = FetchType.LAZY)),

    })
    Clazz selectClazzByName(@Param("major") String major,@Param("grade") String grade,@Param("orders") String orders);


    @Select("select * from clazz")
    @Results({
            @Result(column = "number",property = "number"),
            @Result(column = "name",property = "name"),
            @Result(column = "academicSystem",property = "academicSystem"),
            @Result(column = "major",property = "major"),
            @Result(column = "grade",property = "grade"),
            @Result(column = "orders",property = "orders")
    })
    List<Clazz> selectAllClazz();

    /**
     *
     * @param teacherNumber    要查询的教师号
     * @return    查询一个教师教的所有班级
     */
    @Select("select * from clazz where exists(select clazzNumber from clazzAndteacher where teacherNumber = #{teacherNumber})")
    @Results({
            @Result(column = "number",property = "number"),
            @Result(column = "name",property = "name"),
            @Result(column = "academicSystem",property = "academicSystem"),
            @Result(column = "major",property = "major"),
            @Result(column = "grade",property = "grade"),
            @Result(column = "orders",property = "orders"),
            @Result(column = "number",property = "studentList",
                    many = @Many(select = "com.feng.mapper.StudentMapper.selectStudentByClazzNumber",fetchType = FetchType.LAZY)
            )
    })
    List<Clazz> selectClazzByTeacherNumber(@Param("teacherNumber") String teacherNumber);

}
