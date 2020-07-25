/*
 * UserIdServiceImpl
 * 描述
 @author Sirius
 */
package com.sirius.service.impls;

import com.sirius.dao.mysql.UserIdDao;
import com.sirius.dao.mysql.UserInfoDao;
import com.sirius.domain.UserId;
import com.sirius.domain.UserInfo;
import com.sirius.service.interfaces.UserIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserIdServiceImpl implements UserIdService {
    // 注入id操作数据库接口
    @Autowired
    UserIdDao userIdDao;
    @Autowired
    UserInfoDao userInfoDao;

    @Override
    public Integer getFreeId() {
        // 获取空闲id
        UserId check = userIdDao.selectOne();
        if (check == null) {
            // 如果数据库内不存在空闲id，那么就生成一个
            // 首先获取所有id的最大值
            Integer max = userIdDao.selectMaxId();
            Integer newId = max + 1;
            // 添加id
            int insert = userIdDao.insertById(newId, 1);// 0表示空闲，1表示使用，2表示冻结
            if (insert == 1) {
                return newId;
            }
        } else {
            // 如果已经有空闲id，则返回他，并设置状态为1
            Integer id = check.getId();
            int update = userIdDao.updateStatus(id, 1);
            if (update == 1) {
                return id;
            } else {
                return null;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Integer> cleanId() {
        // 查询所有为非空闲的id
        ArrayList<Integer> idNotFree = userIdDao.selectAllNotFree();
        // 死id集合
        ArrayList<Integer> deadList = new ArrayList<>();
        // 遍历查看这些id是否存在于用户信息的表中，如果存在，则跳过，不存在则置状态为0。
        for (Integer id: idNotFree){
            UserInfo userInfo = userInfoDao.selectUserInfoById(id);
            if (userInfo == null){
                // 置位0
                userIdDao.updateStatus(id, 0);
                // 存入集合
                deadList.add(id);
            }
        }
        return deadList;
    }

    @Override
    public ArrayList<Integer> addIds(Integer nums) {
        // 获取最大的id
        Integer max = userIdDao.selectMaxId();
        // 新增的id的集合
        ArrayList<Integer> ids = new ArrayList<>();
        // 添加id
        for (int id = max + 1; id <= nums; id++){
            userIdDao.insertById(id, 0);
            ids.add(id);
        }
        if (ids.size() != 0){
            return ids;
        }else {
            return null;
        }
    }

    @Override
    public Boolean changeStatus(Integer target, Integer newStatus) {
        return null;
    }

    @Override
    public Integer getStatus(Integer id) {
        return userIdDao.selectStatusById(id);
    }
}
