package com.feng.mapper;

import com.feng.bean.Student;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface StudentMapper {

    /**
     *
     * @param number
     * @return   根据指定的学号或者姓名查找学生
     */
    @Select("select * from student where number = #{number} and " +
            "exists(select * from user where number = #{number} and isExist = 1)")
    @Results({
            @Result(column = "number",property = "number"),
            @Result(column = "name",property = "name"),
            @Result(column = "enthic",property = "enthic"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "institution",property = "institution"),
            @Result(column = "major",property = "major"),
            @Result(column = "clazzNumber",property = "clazzNumber"),
            @Result(column = "fromSchool",property = "fromSchool"),
            @Result(column = "phone",property = "phone")
    })
    Student selectStudent(@Param("number") String number);

    /**
     *
     * @param clazzNumber
     * @return   根据班级号查找一个班级的所有学生
     */
    @Select("select * from student,user where clazzNumber = #{clazzNumber} and student.number = user.number and user.isExist != 0")
    @Results({
            @Result(column = "number",property = "number"),
            @Result(column = "name",property = "name"),
            @Result(column = "enthic",property = "enthic"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "institution",property = "institution"),
            @Result(column = "major",property = "major"),
            @Result(column = "clazzNumber",property = "clazzNumber"),
            @Result(column = "fromSchool",property = "fromSchool"),
            @Result(column = "phone",property = "phone"),
            @Result(column = "grade",property = "grade")
    })
    List<Student> selectStudentByClazzNumber(@Param("clazzNumber") String clazzNumber);


    /**
     * @function 查询所有学生的信息
     */
    @Select("select * from student,user where student.number = user.number and user.isExist != 0")
    @Results({
            @Result(column = "number",property = "number"),
            @Result(column = "name",property = "name"),
            @Result(column = "enthic",property = "enthic"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "institution",property = "institution"),
            @Result(column = "major",property = "major"),
            @Result(column = "clazzNumber",property = "clazzNumber"),
            @Result(column = "fromSchool",property = "fromSchool"),
            @Result(column = "phone",property = "phone"),
            @Result(column = "grade",property = "grade"),
            @Result(column = "number",property = "scoreList",
                   many = @Many(select = "com.feng.mapper.ScoreMapper.selectScoreByStudentNumber"))
            })

    List<Student> selectAllStudent();

    /**
     *
     * @param student
     * @return  添加指定学生的信息
     */
    @Insert("insert into student(number,name,enthic,sex,institution,major,clazzNumber,fromSchool,phone,grade)" +
            "values(#{number},#{name},#{enthic},#{sex},#{institution},#{major},#{clazzNumber},#{fromSchool},#{phone},#{grade})")
    @Options(useGeneratedKeys = true,keyProperty = "number")
    int insertStudent(Student student);



}
