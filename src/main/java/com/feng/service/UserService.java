package com.feng.service;

import com.feng.bean.User;
import com.feng.mapper.UserMapper;
import com.feng.tool.SessionFactory;
import com.feng.tool.UserInfo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserService {
    private SqlSession session = null;
    private UserMapper userMapper = null;

    /**
     *
     * @param number
     * @return  用户登陆
     */
    public User loginUser(String number){
        session = SessionFactory.getSqlSession();
        userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.selectUser(number);
        session.commit();
        return user;
    }

    /**
     *
     * @param user  被添加的用户
     * @return     添加用户是否成功
     */
    public int addUser(User user){
        int isOk = 0;
        session = SessionFactory.getSqlSession();
        userMapper = session.getMapper(UserMapper.class);
        isOk = userMapper.addUser(user);
        session.commit();
        return isOk;

    }

    /**
     *
     * @return   查询所有用户
     */
    public List<User> selectAllUser(){
        session = SessionFactory.getSqlSession();
        userMapper = session.getMapper(UserMapper.class);
        List<User> list = userMapper.selectAllUser();
        session.commit();
        return list;
    }

    /**
     *
     * @param number
     * @return  懒删除用户
     */
    public int deleteUser(String number){
        int isOk = 0;
        session = SessionFactory.getSqlSession();
        userMapper = session.getMapper(UserMapper.class);
        isOk = userMapper.deleteUser(number);
        session.commit();
        return isOk;
    }

    /**
     *
     * @param number       用户账号
     * @param password     用户密码
     * @return
     */
    public int modifyUser(String number,String password){
        int isOk = 0;
        session = SessionFactory.getSqlSession();
        userMapper = session.getMapper(UserMapper.class);
        isOk = userMapper.modifyUser(number,password);
        session.commit();
        return isOk;
    }

    /**
     *
     * @param number
     * @param oldPassword
     * @param newPassword
     * @return  修改用户密码
     */
    public int updatePassword(String number,String oldPassword,String newPassword){
        int isOK = 0;
        session = SessionFactory.getSqlSession();
        userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.selectUser(number);
        if (user == null){
            return isOK;
        }else {
            if (user.getPassword().equals(oldPassword)){
                isOK = userMapper.modifyUser(user.getNumber(),newPassword);
                session.commit();
                return isOK;
            }else {
                return isOK;
            }
        }
    }
}
