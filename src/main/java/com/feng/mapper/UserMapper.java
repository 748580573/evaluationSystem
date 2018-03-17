package com.feng.mapper;

import com.feng.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    /**
     *
     * @param number
     * @return 查找指定的用户
     */
    @Select("select * from user where number = #{number} and isExist = 1")
    @Results({
            @Result(column = "number",property = "number"),
            @Result(column = "password",property = "password"),
            @Result(column = "type",property = "type"),
            @Result(column = "isExist",property = "isExist")
    })
    User selectUser(@Param("number") String number);

    /**
     *
     * @return 查找所以的用户
     */
    @Select("select * from user where isExist = 1")
    @Results({
            @Result(column = "number",property = "number"),
            @Result(column = "password",property = "password"),
            @Result(column = "type",property = "type"),
            @Result(column = "isExist",property = "isExist")
    })

    List<User> selectAllUser();

    @Insert("insert into user(number,password,type) values(#{number},#{password},#{type})")
    @Options(useGeneratedKeys = true,keyProperty = "number")
    int addUser(User user);


    /**
     *
     * @param number  懒删除指定用户
     * @return
     */
    @Update("update user set isExist = 0 where number = #{number}")
    int deleteUser(@Param("number") String number);

    /**
     *
     * @param number
     * @param password
     * @return  修改用户密码
     */
    @Update("update user set password = #{password} where number = #{number}")
    int modifyUser(@Param("number") String number,@Param("password") String password);

}
