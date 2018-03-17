package com.feng.test;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.feng.bean.*;
import com.feng.mapper.ClazzMapper;
import com.feng.mapper.ScoreMapper;
import com.feng.mapper.StudentMapper;
import com.feng.mapper.TeacherMapper;
import com.feng.service.*;
import com.feng.tool.SessionFactory;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;

import java.util.List;


public class InsertTest {
    public static void main(String[] args) throws Exception {
        ScoreService scoreService = new ScoreService();
        List<Score> list = scoreService.selectMultiScore();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(list);
        System.out.println(json);
    }
}
