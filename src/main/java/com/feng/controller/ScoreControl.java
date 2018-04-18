package com.feng.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.feng.bean.Score;
import com.feng.bean.Student;
import com.feng.service.ScoreService;
import com.feng.service.StudentServlce;
import com.feng.tool.JsonUtil;
import com.feng.tool.RegularUtil;
import org.apache.ibatis.annotations.Param;
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
public class ScoreControl {

    @Resource(name = "scoreService")
    private ScoreService scoreService = null;
    @Resource(name = "studentServlce")
    private StudentServlce studentServlce  = null;
    @Autowired
    HttpServletRequest request;

    /**
     *
     * @param
     * @param
     * @return     查询指定学生的所有成绩
     * @throws JsonProcessingException
     */
    @RequestMapping(value = "/selectAllScoreByPeriod",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String selectAllScoreByPeriod() throws JsonProcessingException {
        HttpSession session = request.getSession();
        String studentNumber = (String) session.getAttribute("account");
        Student student = studentServlce.selectStudentByNumber(studentNumber);
        List<Score> list = scoreService.selectAllScoreByPeriod(studentNumber,student.getClazzNumber());
        String json = JsonUtil.asJson(list);
        return json;
    }

    /**
     *
     * @param major
     * @param grade
     * @param orders
     * @return       将班级和课程信息组合形成成绩
     * @throws JsonProcessingException
     */
    @RequestMapping(value = "/getScoreListByClassAndSchedule",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getScoreListByClassAndSchedule(@RequestParam("major")String major, @RequestParam("grade") String grade, @RequestParam("orders") String orders) throws JsonProcessingException  {
        HttpSession session = request.getSession();
        String teacherNumber = (String) session.getAttribute("account");
        List<Score> list = scoreService.getScoreListByClassAndSchedule(major, grade, orders, teacherNumber);
        String json = JsonUtil.asJson(list);
        return json;
    }

    @RequestMapping(value = "/initScore",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String initScore(){
        return "";
    }

    @RequestMapping(value = "/updateScore",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String updateScore(@RequestParam("studentNumber")String studentNumber,@RequestParam("courseNumber")String courseNumber,@RequestParam("clazzNumber") String clazzNumber,@RequestParam("score") String score) throws JsonProcessingException {
        RegularUtil util = new RegularUtil();         //验证成绩格式
        if (util.CheckScore(score)){
            scoreService.updateScore(studentNumber, courseNumber, score);
            List<Score> list = scoreService.selectScoreByClazzNumberAndCourse(clazzNumber, courseNumber);
            String json = JsonUtil.asJson(list);
            System.out.println(json);
            return json;
        }else {
            return "[{\"flag\" : \"0\"}]";
        }
    }

    @RequestMapping(value = "/updateScoreByStudyManager",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String updateScoreByStudyManager(@RequestParam("studentNumber")String studentNumber,@RequestParam("courseNumber")String courseNumber,@RequestParam("clazzNumber") String clazzNumber,@RequestParam("score") String score) throws JsonProcessingException {
        RegularUtil util = new RegularUtil();         //验证成绩格式
        if (util.CheckScore(score)){
            scoreService.updateScore(studentNumber, courseNumber, score);
            List<Score> list = scoreService.selectScoreByStudentNumber(studentNumber);
            String json = JsonUtil.asJson(list);
            return json;
        }else {
            return "[{\"flag\" : \"0\"}]";
        }
    }

    /**
     *
     * @param studentNumber
     * @return       根据学号查询学生成绩
     * @throws JsonProcessingException
     */
    @RequestMapping(value = "/selectScoreByStudentNumber",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String selectScoreByStudentNumber(@RequestParam("studentNumber") String studentNumber) throws JsonProcessingException {
        List<Score> list = scoreService.selectScoreByStudentNumber(studentNumber);
        String json = JsonUtil.asJson(list);
        return json;
    }

    /**
     *
     * @return    查询学生综测成绩
     * @throws JsonProcessingException
     */
    @RequestMapping(value = "/selectStudentMulitScore",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String  selectStudentMulitScore() throws JsonProcessingException {
        List<Score> list = scoreService.selectMultiScore();
        String json = JsonUtil.asJson(list);
        return json;
    }

}
