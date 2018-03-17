package com.feng.mapper;

import com.feng.bean.Score;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ScoreMapper {

    /**
     * 查询学生某个学期的成绩
     */
    @Select("select * from score where period = #{period} or studentNumber = #{studentNumber}")
    @Results({
            @Result(column = "courseNumber",property = "courseNumber"),
            @Result(column = "name",property = "name"),
            @Result(column = "studentNumber",property = "studentNumber"),
            @Result(column = "type",property = "type"),
            @Result(column = "credit",property = "credit"),
            @Result(column = "score",property = "score"),
            @Result(column = "period",property = "period"),
            @Result(column = "clazzNumber",property = "clazzNumber"),
            @Result(column = "teacher",property = "teacher"),
            @Result(column = "studentName",property = "studentName")
    })
    List<Score> selectAllScoreByPeriod( @Param("studentNumber") String studentNumber,@Param("period") String period);


    /**
     *
     * @return 查询所有成绩单
     */
    @Select("select * from score")
    @Results({
            @Result(column = "courseNumber",property = "courseNumber"),
            @Result(column = "name",property = "name"),
            @Result(column = "studentNumber",property = "studentNumber"),
            @Result(column = "type",property = "type"),
            @Result(column = "credit",property = "credit"),
            @Result(column = "score",property = "score"),
            @Result(column = "period",property = "period"),
            @Result(column = "clazzNumber",property = "clazzNumber"),
            @Result(column = "teacher",property = "teacher"),
            @Result(column = "studentName",property = "studentName")
    })
    List<ScoreMapper> selectAllScore();


    @Insert("insert into score(courseNumber,clazzNumber,teacher,name,studentNumber,studentName,type,credit,score,period)" +
            "values(#{courseNumber},#{clazzNumber},#{teacher},#{name},#{studentNumber},#{studentName},#{type},#{credit},#{score},#{period})")
    int addScore(Score score);

    /**
     *
     * @param clazzNumber
     * @param studentNumber
     * @return  删除指定科目或者指定学生的成绩
     */
    @Delete("delete from score where clazzNumber = #{clazzNumber} or studentNumber = #{studentNumber}")
    int deleteScore(@Param("clazzNumber") String clazzNumber,@Param("studentNumber") String studentNumber);

    /**
     *
     * @param courseNumber
     * @param studentNumber
     * @param score
     * @return 修改某个学生某一科的成绩
     */
    @Update("update score set score = #{score} where courseNumber = #{courseNumber} and studentNumber = #{studentNumber}")
    int updateScore(@Param("studentNumber")String studentNumber,@Param("courseNumber") String courseNumber,@Param("score")String score);


    /**
     *
     * @param clazzNumber
     * @return      根据班级号查询某一班学生成绩
     */
    @Select("select * from score where clazzNumber = #{clazzNumber}")
    @Results({
            @Result(column = "courseNumber",property = "courseNumber"),
            @Result(column = "name",property = "name"),
            @Result(column = "studentNumber",property = "studentNumber"),
            @Result(column = "type",property = "type"),
            @Result(column = "credit",property = "credit"),
            @Result(column = "score",property = "score"),
            @Result(column = "period",property = "period"),
            @Result(column = "clazzNumber",property = "clazzNumber"),
            @Result(column = "teacher",property = "teacher"),
            @Result(column = "studentName",property = "studentName")
    })
    List<Score> selectScoreByClazzNumber(@Param("clazzNumber") String clazzNumber);


    /**
     *
     * @param clazzNumber
     * @param name
     * @return   查询某班某科成绩
     */
    @Select("select * from score where clazzNumber = #{clazzNumber} and name = #{name}")
    @Results({
            @Result(column = "courseNumber",property = "courseNumber"),
            @Result(column = "name",property = "name"),
            @Result(column = "studentNumber",property = "studentNumber"),
            @Result(column = "type",property = "type"),
            @Result(column = "credit",property = "credit"),
            @Result(column = "score",property = "score"),
            @Result(column = "period",property = "period"),
            @Result(column = "clazzNumber",property = "clazzNumber"),
            @Result(column = "teacher",property = "teacher"),
            @Result(column = "studentName",property = "studentName")
    })
    List<Score> selectScoreByClazzNumberAndSchedule(@Param("clazzNumber") String clazzNumber,@Param("name") String name);

    /**
     *
     * @param courseNumber
     * @param studentNumber
     * @param period
     * @return   查询学生某学期某科成绩
     */
    @Select("select * from score where courseNumber = #{courseNumber} and studentNumber = #{studentNumber} and period = #{period}")
    @Results({
            @Result(column = "courseNumber",property = "courseNumber"),
            @Result(column = "name",property = "name"),
            @Result(column = "studentNumber",property = "studentNumber"),
            @Result(column = "type",property = "type"),
            @Result(column = "credit",property = "credit"),
            @Result(column = "score",property = "score"),
            @Result(column = "period",property = "period"),
            @Result(column = "clazzNumber",property = "clazzNumber"),
            @Result(column = "teacher",property = "teacher"),
            @Result(column = "studentName",property = "studentName")
    })
    Score selectScore(@Param("courseNumber") String courseNumber,@Param("studentNumber") String studentNumber,@Param("period") String period);

    @Select("select * from score where clazzNumber = #{clazzNumber} and courseNumber = #{courseNumber}")
    @Results({
            @Result(column = "courseNumber",property = "courseNumber"),
            @Result(column = "name",property = "name"),
            @Result(column = "studentNumber",property = "studentNumber"),
            @Result(column = "type",property = "type"),
            @Result(column = "credit",property = "credit"),
            @Result(column = "score",property = "score"),
            @Result(column = "period",property = "period"),
            @Result(column = "clazzNumber",property = "clazzNumber"),
            @Result(column = "teacher",property = "teacher"),
            @Result(column = "studentName",property = "studentName")
    })
    List<Score> selectScoreByClazzNumberAndCourse(@Param("clazzNumber") String clazzNumber,@Param("courseNumber") String courseNumber);

    /**
     *
     * @param studentNumber
     * @return    根据学号查询学生信息
     */
    @Select("select * from score where studentNumber = #{studentNumber}")
    @Results({
            @Result(column = "courseNumber",property = "courseNumber"),
            @Result(column = "name",property = "name"),
            @Result(column = "studentNumber",property = "studentNumber"),
            @Result(column = "type",property = "type"),
            @Result(column = "credit",property = "credit"),
            @Result(column = "score",property = "score"),
            @Result(column = "period",property = "period"),
            @Result(column = "clazzNumber",property = "clazzNumber"),
            @Result(column = "teacher",property = "teacher"),
            @Result(column = "studentName",property = "studentName")
    })
    List<Score> selectScoreByStudentNumber(@Param("studentNumber") String studentNumber);


}
