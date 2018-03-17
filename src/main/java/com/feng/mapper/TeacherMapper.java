package com.feng.mapper;

import com.feng.bean.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;
public interface TeacherMapper {

    /**
     *
     * @param number
     * @param
     * @return  根据教师号 查询指定的教师用户
     */
    @Select("select * from teacher,user where teacher.number = #{number} and user.number = #{number} and user.isExist = 1")
    @Results({
            @Result(column = "number",property = "number"),
            @Result(column = "name",property = "name"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "major",property = "major"),
            @Result(column = "institution",property = "institution"),
            @Result(column = "phone",property = "phone"),
            @Result(column = "number",property = "clazzList",
                   many = @Many(select = "com.feng.mapper.ClazzMapper.selectClazzByTeacherNumber"))
    })
    Teacher selectTeacher(@Param("number") String number);

    /**
     *
     * @return  查询所有教师用户
     */
    @Select("select * from teacher,user where teacher.number = user.number and user.isExist = 1")
    @Results({
            @Result(column = "number",property = "number"),
            @Result(column = "name",property = "name"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "major",property = "major"),
            @Result(column = "institution",property = "institution"),
            @Result(column = "phone",property = "phone"),
            @Result(column = "number",property = "clazzList",
                    many = @Many(select = "com.feng.mapper.ClazzMapper.selectClazzByTeacherNumber"))
    })
    List<Teacher> selectAllTeacher();

    /**
     *
     * @param teacher
     * @return      添加教师用户
     */
    @Insert("insert into teacher(number,name,sex,major,institution,phone) " +
            "values(#{number},#{name},#{sex},#{major},#{institution},#{phone})")
    @Options(useGeneratedKeys = true,keyProperty = "number")
    int insertTeacher(Teacher teacher);

    @Select("select * from teacher where exists(select teacherNumber from clazzAndteacher where clazzNumber = #{clazzNumber})")
    public List<Teacher> selectTeacherByClazzNumber(@Param("clazzNumber") String clazzNumber);


}
