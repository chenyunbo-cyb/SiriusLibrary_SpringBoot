package com.sirius.dao.mysql;

import com.sirius.domain.UserLogin;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.Date;

public interface UserLoginDao {
    /*查询*/
    // 根据用户名查询
    UserLogin selectUserLoginByUserName(String username);
    // 通过id查询用户名
    String selectUserNameById(Integer id);
    // 根据最后登录时间区间查询
    ArrayList<UserLogin> selectUserLoginByTimeSection(@Param("left") Date left, @Param("right") Date right);
    // 根据id查询
    UserLogin selectUserLoginById(Integer id);
    // 登录查询
    UserLogin loginCheck(@Param("username") String username, @Param("password") String password);
    // 盐值查询
    String selectSalt(String username);
    /*修改*/
    // 根据用户名修改密码
    int updatePasswordByName(@Param("username") String username, @Param("password") String password, @Param("salt") String salt);
    // 修改对象
    int updateUserLogin(@Param("oldUserLogin") UserLogin oldUserLogin, @Param("newLogin") UserLogin newLogin);
    // 根据用户名修改登录时间
    int updateLastTimeByName(@Param("name") String name, @Param("date") Date date);
    // 根据对象修改用户时间
    int updateLastTimeByUserLogin(@Param("target") UserLogin target, @Param("date") Date date);
    // 根据id修改密码
    int updatePasswordById(@Param("id") Integer id, @Param("password") String password, @Param("salt") String salt);
    // 根据对象修改密码
    int updatePasswordByUserLogin(@Param("userLogin") UserLogin userLogin, @Param("password") String password, @Param("salt") String salt);
    /*添加*/
    // 添加UserLogin
    int insertUserLogin(UserLogin userLogin);
}
