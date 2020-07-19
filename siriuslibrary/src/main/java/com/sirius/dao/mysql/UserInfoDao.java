package com.sirius.dao.mysql;

import com.sirius.domain.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface UserInfoDao {
    /*查询*/
    // 根据id查询
    UserInfo selectUserInfoById(Integer id);
    // 根据用户名称查询
    ArrayList<UserInfo> selectUserInfoByName(String name);
    // 根据vip类型查询
    ArrayList<UserInfo> selectUserInfoByVIP(String vip);
    // 根据性别查询
    ArrayList<UserInfo> selectUserInfoBySex(String sex);
    // 根据对象查询
    UserInfo selectUserInfo(UserInfo userInfo);
    // 根据电话查询
    UserInfo selectUserInfoByTel(String tel);
    // 查询用户数量
    Integer selectCount();
    // 根据条件查询数量，参数为对象，可选条件，非选择条件对象参数为null。
    Integer selectCountByCondition(UserInfo userInfo);
    // 根据条件查询，参数为对象，可选条件，非选择条件对象参数为null。
    ArrayList<UserInfo> selectByCondition(UserInfo userInfo);
    // 根据id查询用户类型
    String selectVIPById(Integer id);
    /*修改*/
    // 修改对象
    int updateUserInfo(@Param("oldUserInfo") UserInfo oldUserInfo, @Param("newUserInfo") UserInfo newUserInfo);
    // 根据id
    int updateUserInfoById(@Param("id") Integer id, @Param("newUserInfo") UserInfo newUserInfo);
    // 修改用户类型
    int updateVip(@Param("id") Integer id, @Param("vip") String vip);
    /*删除*/
    // 根据id删除
    int deleteUserInfoById(Integer id);
    // 根据对象删除
    int deleteUserInfo(UserInfo userInfo);
    // 根据条件删除，参数为对象，非选择条件对象参数为null
    int deleteUserInfoByCondition(UserInfo userInfo);
    /*增加*/
    int insertUserInfo(UserInfo userInfo);
}
