package com.feng.service;

import com.feng.bean.Clazz;
import com.feng.bean.Student;
import com.feng.bean.Teacher;
import com.feng.bean.User;
import com.feng.mapper.TeacherMapper;
import com.feng.tool.SessionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class TeacherService {
    private SqlSession session = null;
    private TeacherMapper teacherMapper = null;

    /**
     *
     * @param teacherNumber
     * @return    根据教师号查询教师
     */
    public List<Student> selectTeacherStudent(String teacherNumber){
        session = SessionFactory.getSqlSession();
        teacherMapper = session.getMapper(TeacherMapper.class);
        List<Student> list = new ArrayList<Student>();
        Teacher teacher = teacherMapper.selectTeacher(teacherNumber);
        List<Clazz> clazz = teacher.getClazzList();
        for (Clazz clazz1 : clazz){
            List<Student> students = clazz1.getStudentList();
            list.addAll(students);
        }
        return list;
    }

    /**
     *
     * @return   查询所有老师的信息
     */
    public List<Teacher> selectAllTeacher(){
        session = SessionFactory.getSqlSession();
        teacherMapper = session.getMapper(TeacherMapper.class);
        List<Teacher> list = teacherMapper.selectAllTeacher();
        for (Teacher teacher : list){
            teacher.getClazzList().clear();
        }
        return list;
    }

    /**
     *
     * @param teacher
     * @return  添加教师
     */
    public int addTeacher(Teacher teacher){
        UserService userService = new UserService();
        User user = new User();
        user.setPassword("123456");
        user.setNumber(teacher.getNumber());
        user.setType("教师");
        userService.addUser(user);
        session = SessionFactory.getSqlSession();
        teacherMapper = session.getMapper(TeacherMapper.class);
        int isOK = teacherMapper.insertTeacher(teacher);
        session.commit();
        return isOK;
    }

}
