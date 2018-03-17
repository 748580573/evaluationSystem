package com.feng.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.feng.bean.Clazz;
import com.feng.bean.Student;
import com.feng.service.ClazzService;
import com.feng.service.StudentServlce;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ClazzControl {

    private ClazzService clazzService = null;
    @Autowired
    private HttpServletRequest request;



    @RequestMapping(value = "/selectClazzByNumber",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String selectClazzByNumber(@RequestParam("number") String number) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        clazzService = new ClazzService();
        Clazz clazz = clazzService.selectClazzByNumber(number);
        String json = objectMapper.writeValueAsString(clazz);
        return json;
    }

    @RequestMapping(value = "/selectClazzByName",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String selectClazzByName(@Param("major") String major, @Param("grade") String grade, @Param("orders") String orders) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        clazzService = new ClazzService();
        Clazz clazz = clazzService.selectClazzByName(major, grade, orders);
        String json = objectMapper.writeValueAsString(clazz);
        return json;
    }

    @RequestMapping(value = "/selectAllClazz",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String selectAllClazz() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        clazzService = new ClazzService();
        List<Clazz> list = clazzService.selectAllClazz();
        String json = objectMapper.writeValueAsString(list);
        return json;
    }



}
