package com.feng.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.feng.bean.Student;
import com.feng.bean.User;
import com.feng.service.StudentServlce;
import com.feng.service.UserService;
import com.feng.tool.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class StudentControl {
    @Resource(name = "studentServlce")
    private StudentServlce studentServlce = null;
    @Resource(name = "userService")
    private UserService userService = null;
    @Autowired
    HttpServletRequest request;
    /**
     *
     * @param student
     * @return  添加学生用户
     */
    @RequestMapping("/addStudent")
    public String addStudent(Student student){
        User user = new User();                          //先添加用户信息
        user.setNumber(student.getNumber());
        user.setPassword("123456");                      //默认密码123456
        user.setType("学生");
        userService.addUser(user);
        studentServlce.studentAdd(student);
        return "{\"flag\":\"成功\"";
    }

    /**
     *
     * @return  查询所有学生信息
     * @throws JsonProcessingException
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = "/selectAllStudnet",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String selectAllStudnet() throws JsonProcessingException, UnsupportedEncodingException {
        List<Student> list = studentServlce.selectAllStudent();
        String json = JsonUtil.asJson(list);
        return json;
    }

    /**
     *
     * @param number
     * @return  删除学生
     * @throws JsonProcessingException
     */
    @RequestMapping(value = "/deleteStudent",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String deleteStudent(@RequestParam(value = "number",required = true) String number) throws JsonProcessingException {
        studentServlce.deleteStudnet(number);
        List<Student> list = studentServlce.selectAllStudent();
        String json = JsonUtil.asJson(list);
        return json;
    }

    /**
     *
     * @param
     * @return  根据学号选择学生
     * @throws JsonProcessingException
     */
    @RequestMapping(value = "/selectStudentByNumber",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String selectStudentByNumber() throws JsonProcessingException {
        HttpSession session = request.getSession();
        String number = (String) session.getAttribute("account");
        Student student = studentServlce.selectStudentByNumber(number);
        String json = JsonUtil.asJson(student);
        return json;
    }

    /**
     *
     * @param clazzNumber
     * @return  根据班级号选择一个班级的所有学生
     * @throws JsonProcessingException
     */
    @RequestMapping(value = "/selectStudentByClazzNumber",produces = "text/html;charset=UTF-8")
    @ResponseBody

    public String selectStudentByClazzNumber(@RequestParam("clazzNumber") String clazzNumber) throws JsonProcessingException {
        List<Student> list = studentServlce.selectStudentByClazzNumber(clazzNumber);
        String json = JsonUtil.asJson(studentServlce);
        return json;
    }
}
