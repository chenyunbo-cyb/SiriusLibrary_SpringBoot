package com.sirius.dao.mysql;

import com.sirius.domain.UserId;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface UserIdDao {
    /*查询*/
    // 获取一个空闲的id
    UserId selectOne();
    // 获取所有指定状态的id
    ArrayList<UserId> selectAllByStatus(Integer flag);
    // 查询非空闲的id
    ArrayList<Integer> selectAllNotFree();
    // 获取id状态
    Integer selectStatusById(Integer id);
    // 查询最大的id值
    Integer selectMaxId();
    // 获取指定状态id的最大值
    Integer selectMaxIdByStatus(Integer flag);
    /*增加*/
    // 增加对象
    int insertOne(UserId newUserId);
    // 增加指定状态的id
    int insertById(@Param("id") Integer id, @Param("flag") Integer flag);
    /*修改*/
    // 修改id状态
    int updateStatus(@Param("id") Integer id, @Param("flag") Integer flag);
}
