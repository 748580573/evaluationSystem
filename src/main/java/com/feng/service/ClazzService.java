package com.feng.service;

import com.feng.bean.Clazz;
import com.feng.mapper.ClazzMapper;
import com.feng.tool.SessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("clazzService")
public class ClazzService {


    private SqlSession session =  null;
    private ClazzMapper clazzMapper = null;
    /**
     *
     * @param number
     * @return   根据班级号查找班级
     */
    public Clazz selectClazzByNumber(String number){
        session = SessionFactory.getSqlSession();
        clazzMapper = session.getMapper(ClazzMapper.class);
        Clazz  clazz = clazzMapper.selectClazzByNumber(number);
        session.commit();
        return clazz;
    }

    /**
     *
     * @param major
     * @param grade
     * @param orders
     * @return   根据年级 专业 班级 查找一个班级
     */
    public Clazz selectClazzByName(String major,String grade,String orders){
        session = SessionFactory.getSqlSession();
        clazzMapper = session.getMapper(ClazzMapper.class);
        Clazz clazz = clazzMapper.selectClazzByName(major, grade, orders);
        session.commit();
        return clazz;
    }

    /**
     *
     * @return    查找所有班级信息
     */
    public List<Clazz> selectAllClazz(){
        session = SessionFactory.getSqlSession();
        clazzMapper = session.getMapper(ClazzMapper.class);
        List<Clazz>  list = clazzMapper.selectAllClazz();
        session.commit();
        return list;
    }




}
