package com.feng.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.feng.bean.Table;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MyTest {

    @RequestMapping("/test")
    @ResponseBody
    public String getCustomerList(@RequestParam(value = "limit",required = false) Integer limit,
                                  @RequestParam(value = "offest",required = false) Integer offest,
                                  @RequestParam(value = "search",required = false)String search) throws JsonProcessingException {
        System.out.println("进入到该方法");
        ObjectMapper objectMapper = new ObjectMapper();
        List<Table> list = new ArrayList<Table>();
        Table table = new Table();
        table.setPrice(25.5F);
        table.setName("wu");
        table.setBookId(1);
        table.setNumber(123);
        list.add(table);
        list.add(table);
        String json = objectMapper.writeValueAsString(list);
        System.out.println(json);
        return json;

    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam(value = "test",required = false) String test) throws JsonProcessingException {

        System.out.println("test的值为：" + test);
        ObjectMapper objectMapper = new ObjectMapper();
        List<Table> list = new ArrayList<Table>();
        Table table = new Table();
        table.setPrice(25.5F);
        table.setName("guo");
        table.setBookId(1);
        list.add(table);
        Table table2 = new Table();
        table2.setPrice(25.5F);
        table2.setName("wu");
        table2.setBookId(1);
        list.add(table2);
        String json = objectMapper.writeValueAsString(list);
        System.out.println(json);
        return json;
    }
}
