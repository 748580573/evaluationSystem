package com.feng.tool;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class SessionFactory {
    private static SqlSessionFactory sqlSessionFactory = null;

    static {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }catch (Exception e){
            System.out.println("mybatis加载错误");
        }
    }

    /**
     *
     * @return 获取session
     */
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();

    }

    /**
     *
     * @return  获取sessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }

    /**
     * 关闭连接
     */
    public static void close(){

    }

}
