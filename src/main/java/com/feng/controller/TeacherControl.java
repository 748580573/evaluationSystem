package com.feng.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.feng.bean.Student;
import com.feng.bean.Teacher;
import com.feng.service.StudentServlce;
import com.feng.service.TeacherService;
import com.feng.tool.JsonUtil;
import com.feng.tool.RegularUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TeacherControl {

    @Resource(name = "teacherService")
    private TeacherService teacherService = null;
    @Autowired
    HttpServletRequest request;

    @RequestMapping(value = "/selectTeacherStudent",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String selectTeacherStudent() throws JsonProcessingException {
        HttpSession session = request.getSession();

        String teacherNumber = (String) session.getAttribute("account");
        System.out.println("教师编号" + teacherNumber);
        List<Student> list = teacherService.selectTeacherStudent(teacherNumber);
        System.out.println("学生" + list);
        String json = JsonUtil.asJson(list);
        return json;
    }

    @RequestMapping(value = "/selectStudentFromTeacher",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String selectStudentByNumber(@RequestParam("studentNumber") String studentNumber) throws JsonProcessingException {

        StudentServlce studentServlce = new StudentServlce();
        Student student = studentServlce.selectStudentByNumber(studentNumber);
        String json = JsonUtil.asJson(student);
        return json;
    }

    @RequestMapping(value = "/selectAllTeacher",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String selectAllTeacher() throws JsonProcessingException {
        List<Teacher> list = teacherService.selectAllTeacher();
        String json = JsonUtil.asJson(list);
        return json;
    }

    @RequestMapping(value = "/addTeacher",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String addTeacher(Teacher teacher){
        RegularUtil regularUtil = new RegularUtil();
        if (!regularUtil.CheckTeacherAccount(teacher.getNumber())){
            return "[{\"flag\":\"0\"}]";
        }
        int flag = teacherService.addTeacher(teacher);
        if (flag != 0){
            return "[{\"flag\":\"1\"}]";
        }else {
            return "[{\"flag\":\"0\"}]";
        }
    }
}
