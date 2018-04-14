package com.feng.test;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.feng.bean.Schedule;
import com.feng.service.ScheduleService;
import com.feng.tool.AccountUtil;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InsertTest {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        ScheduleService scheduleService = new ScheduleService();
        List<Schedule> list = scheduleService.selectAllSchedule("04","6");
        String json = objectMapper.writeValueAsString(list);
        System.out.println(json);



    }
}
