package com.feng.service;

import com.feng.mapper.ClazzAndTeacherMapper;
import com.feng.tool.SessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service("clazzAndTeacherMapperService")
public class ClazzAndTeacherMapperService {
    private SqlSession session = SessionFactory.getSqlSession();
    private ClazzAndTeacherMapper clazzAndTeacherMapper = session.getMapper(ClazzAndTeacherMapper.class);

    int assosicateClazzAndTeacher( String clazzNumber, String teacherNumber){
        int isOK = clazzAndTeacherMapper.assosicateClazzAndTeacher(clazzNumber, teacherNumber);
        session.commit();
        return isOK;
    }

}
