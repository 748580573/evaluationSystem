package com.feng.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.feng.bean.Clazz;
import com.feng.bean.Student;
import com.feng.service.ClazzService;
import com.feng.service.StudentServlce;
import com.feng.tool.JsonUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ClazzControl {

    @Resource(name = "clazzService")
    private ClazzService clazzService = null;
    @Autowired
    private HttpServletRequest request;



    @RequestMapping(value = "/selectClazzByNumber",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String selectClazzByNumber(@RequestParam("number") String number) throws JsonProcessingException {
        Clazz clazz = clazzService.selectClazzByNumber(number);
        String json = JsonUtil.asJson(clazz);
        return json;
    }

    @RequestMapping(value = "/selectClazzByName",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String selectClazzByName(@Param("major") String major, @Param("grade") String grade, @Param("orders") String orders) throws JsonProcessingException {
        Clazz clazz = clazzService.selectClazzByName(major, grade, orders);
        String json =  JsonUtil.asJson(clazz);
        return json;
    }

    @RequestMapping(value = "/selectAllClazz",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String selectAllClazz() throws JsonProcessingException {
        List<Clazz> list = clazzService.selectAllClazz();
        String json =  JsonUtil.asJson(list);
        return json;
    }



}
