package com.feng.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.feng.bean.Schedule;
import com.feng.service.ScheduleService;
import com.feng.tool.Flag;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ScheduleControl {
    private ScheduleService scheduleService = null;
    @Autowired
    private HttpServletRequest request;

    /**
     *
     * @return    查询所有课程
     * @throws JsonProcessingException
     */
    @RequestMapping(value = "/selectAllSchedule",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String selectAllSchedule() throws JsonProcessingException {
        HttpSession session = request.getSession();
        System.out.println("账号为：" + session.getAttribute("account"));
        ObjectMapper objectMapper =  new ObjectMapper();
        scheduleService =  new ScheduleService();
        List<Schedule> list = scheduleService.selectAllSchedule("04");
        String json = objectMapper.writeValueAsString(list);
        return json;
    }

    @RequestMapping(value = "/addSchedule",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String addSchedule(Schedule schedule) throws JsonProcessingException {
        Flag flag = new Flag();
        ObjectMapper objectMapper =  new ObjectMapper();
        scheduleService =  new ScheduleService();
        flag.isOK = scheduleService.scheduleAdd(schedule);
        String json = objectMapper.writeValueAsString(flag);
        return json;
    }

    @RequestMapping(value = "/selectScheduleByClazzNumberAndPeriod",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String selectScheduleByClazzNumberAndPeriod(@RequestParam("clazzNumber") String clazzNumber, @RequestParam("period") String period) throws JsonProcessingException {
        ObjectMapper objectMapper =  new ObjectMapper();
        scheduleService =  new ScheduleService();
        System.out.println("参数：" + clazzNumber + " " + period);
        List<Schedule> list = scheduleService.selectScheduleByClazzNumberAndPeriod(clazzNumber, period);
        String json = objectMapper.writeValueAsString(list);
        System.out.println(json);
        return json;
    }
}
