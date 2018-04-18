package com.feng.service;

import com.feng.bean.Student;
import com.feng.bean.Teacher;
import com.feng.bean.User;
import com.feng.mapper.StudentMapper;
import com.feng.mapper.UserMapper;
import com.feng.tool.SessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentServlce")
public class StudentServlce {

    private SqlSession session = null;
    private StudentMapper studentMapper = null;
    private UserMapper userMapper = null;

    /**
     *
     * @param student  添加学生
     */
    public int studentAdd(Student student){
        int isOk = 0;
        session = SessionFactory.getSqlSession();
        studentMapper = session.getMapper(StudentMapper.class);
        User user = new User();
        user.setPassword(student.getNumber());
        user.setPassword("123456");
        user.setType("studnet");
        isOk = studentMapper.insertStudent(student);
        session.commit();
        return isOk;
    }



    /**
     *
     * @return  查询所有学生信息
     */
    public List<Student> selectAllStudent(){
        session = SessionFactory.getSqlSession();
        studentMapper = session.getMapper(StudentMapper.class);
        List<Student> list = studentMapper.selectAllStudent();
        for (Student student : list){
            student.getScoreList().clear();
        }
        session.commit();
        return list;
    }

    /**
     *
     * @param number
     * @return   删除指定number的用户
     */
    public int deleteStudnet(String number){
        int isOk = 0;
        session = SessionFactory.getSqlSession();
        userMapper = session.getMapper(UserMapper.class);
        isOk = userMapper.deleteUser(number);
        session.commit();
        return isOk;
    }

    /**
     *
     * @param number
     * @return     根据学号查找学生
     */
    public Student selectStudentByNumber(String number){
        session = SessionFactory.getSqlSession();
        studentMapper = session.getMapper(StudentMapper.class);
        Student student = studentMapper.selectStudent(number);
        return student;
    }

    /**
     *
     * @param clazzNumber
     * @return     查找某个班级的学生
     */
    public List<Student> selectStudentByClazzNumber(String clazzNumber){
        session = SessionFactory.getSqlSession();
        studentMapper = session.getMapper(StudentMapper.class);
        List<Student> list = studentMapper.selectStudentByClazzNumber(clazzNumber);
        return list;
    }


}
