package com.feng.service;

import com.feng.bean.Score;
import com.feng.bean.Student;
import com.feng.mapper.ScoreMapper;
import com.feng.mapper.StudentMapper;
import com.feng.tool.ScoreList;
import com.feng.tool.SessionFactory;
import com.feng.tool.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Service("scoreService")
public class ScoreService {
    private SqlSession session =  null;
    private ScoreMapper scoreMapper = null;

    /**
     *
     * @param studentNumber
     * @param period
     * @return  查询某个学生某一学期的成绩
     */
    public List<Score> selectAllScoreByPeriod(String studentNumber,String period){
        List<Score> mulitScore = selectMultiScore();
        session = SessionFactory.getSqlSession();
        scoreMapper = session.getMapper(ScoreMapper.class);
        List<Score> list = scoreMapper.selectAllScoreByPeriod(studentNumber,period);
        session.commit();
        for (Score score : mulitScore){
            if (score.getStudentNumber().equals(studentNumber)){
                list.add(score);
            }
        }
        return list;
    }

    /**
     *
     * @param studentNumber
     * @param courseNumber
     * @param score
     * @return  修改成绩
     */

    public int updateScore(String studentNumber,String courseNumber,String score){
        int isOK = 0;
        session = SessionFactory.getSqlSession();
        scoreMapper = session.getMapper(ScoreMapper.class);
        isOK = scoreMapper.updateScore(studentNumber,courseNumber,score);
        session.commit();
        return isOK;
    }

    /**
     *
     * @param clazzNumber
     * @return   根据班级号查询某一班学生成绩
     */
    public List<Score> selectScoreByClazzNumber(String clazzNumber){
        session = SessionFactory.getSqlSession();
        scoreMapper = session.getMapper(ScoreMapper.class);
        List<Score> list = scoreMapper.selectScoreByClazzNumber(clazzNumber);
        session.commit();
        return list;
    }

    /**
     *
     * @param clazzNumber
     * @param name
     * @return   查找某班某科目的成绩
     */
    public  List<Score> selectScoreByClazzNumberAndSchedule(String clazzNumber, String name){
        session = SessionFactory.getSqlSession();
        scoreMapper = session.getMapper(ScoreMapper.class);
        List<Score> list = scoreMapper.selectScoreByClazzNumberAndSchedule(clazzNumber, name);
        session.commit();
        return list;
    }

    /**
     *
     * @param major
     * @param grade
     * @param orders
     * @param teacherNumber
     * @return        根据教师编号和课程进行score拼凑(在以一次拼凑成绩信息时同时创建成绩信息表)
     */
    public List<Score> getScoreListByClassAndSchedule(String major,String grade,String orders,String teacherNumber){
        ScoreList scoreList = new ScoreList();
        List<Score> list = scoreList.getScoreListByClassAndSchedule(major, grade, orders, teacherNumber);

        session = SessionFactory.getSqlSession();
        scoreMapper = session.getMapper(ScoreMapper.class);
        String clazzNumber = list.get(0).getClazzNumber();
        String courseNumber = list.get(0).getCourseNumber();

        for (Score score : list){
            if (selectScore(score) == null){
                insertScore(score);
            }
        }

        list = scoreMapper.selectScoreByClazzNumberAndCourse(clazzNumber,courseNumber);
        session.commit();
        return list;
    }

    /**
     *
     * @param score
     * @return    选择学生某一学期某一科成绩
     */
    public Score selectScore(Score score){
        session = SessionFactory.getSqlSession();
        scoreMapper = session.getMapper(ScoreMapper.class);
        Score info = scoreMapper.selectScore(score.getCourseNumber(),score.getStudentNumber(),score.getPeriod());
        session.commit();
        return info;
    }

    /**
     *
     * @param score
     * @return   添加成绩
     */
    public int insertScore(Score score){
        int isOK = 0;
        session = SessionFactory.getSqlSession();
        scoreMapper = session.getMapper(ScoreMapper.class);
        isOK = scoreMapper.addScore(score);
        session.commit();
        return isOK;
    }

    /**
     *
     * @param clazzNumber    班级号
     * @param courseNumber   课程号
     * @return       查询某班某科成绩
     */
    public List<Score> selectScoreByClazzNumberAndCourse(String clazzNumber,String courseNumber){
        session = SessionFactory.getSqlSession();
        scoreMapper = session.getMapper(ScoreMapper.class);
        List<Score> list = scoreMapper.selectScoreByClazzNumberAndCourse(clazzNumber, courseNumber);
        session.commit();
        return list;
    }

    /**
     *
     * @param studentNumber
     * @return    根据学号选择学生的成绩
     */
    public List<Score> selectScoreByStudentNumber(String studentNumber){
        session = SessionFactory.getSqlSession();
        scoreMapper = session.getMapper(ScoreMapper.class);
        List<Score> list = scoreMapper.selectScoreByStudentNumber(studentNumber);
        session.commit();
        return list;
    }

    /**
     *   查询综测成绩
     * @return
     */
    public List<Score> selectMultiScore(){
        session = SessionFactory.getSqlSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        List<Student> studentList = studentMapper.selectAllStudent();
        DecimalFormat   fnum  =   new DecimalFormat("##0.0");
        session.commit();
        List<Score> list = new ArrayList<Score>();
        for (Student student : studentList){
            float score = 0;
            Float credit = 0F;
            for (Score scores : student.getScoreList()){
                score += (Float.valueOf(scores.getScore()) * Float.valueOf(scores.getCredit()));
                credit+= Float.valueOf(scores.getCredit());
            }
            Score multiScore = student.getScoreList().get(0);
            multiScore.setName("综合素质测评");
            score = score / credit;

            multiScore.setCourseNumber("0000001");
            multiScore.setScore(fnum.format(score));
            multiScore.setTeacher("无");
            list.add(multiScore);
        }
        return list;
    }
}
