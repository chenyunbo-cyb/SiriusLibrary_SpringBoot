/*
 * UserIdService
 * 操作用户id
 @author Sirius
 */
package com.sirius.service.interfaces;

import java.util.ArrayList;

public interface UserIdService {
    // 获取一个空闲id
    Integer getFreeId();
    // 批量增加表内id
    ArrayList<Integer> addIds(Integer nums);
    // 改变id状态
    Boolean changeStatus(Integer target, Integer newStatus);
    // 获取id状态
    Integer getStatus(Integer id);
    // 清理死id
    ArrayList<Integer> cleanId();

}
