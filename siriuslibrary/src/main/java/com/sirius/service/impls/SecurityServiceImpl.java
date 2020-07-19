/*
 * SecurityServiceImpl
 * 描述
 @author Sirius
 */
package com.sirius.service.impls;

import com.sirius.dao.mysql.UserIdDao;
import com.sirius.dao.mysql.UserInfoDao;
import com.sirius.dao.mysql.UserLoginDao;
import com.sirius.domain.UserId;
import com.sirius.domain.UserInfo;
import com.sirius.domain.UserLogin;
import com.sirius.service.interfaces.SecurityService;
import com.sirius.tools.PasswordProcessing;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;

public class SecurityServiceImpl implements SecurityService {
    // 自动注入密码处理模块
    @Autowired
    PasswordProcessing passwordProcessing;
    // 注入数据库接口
    @Autowired
    UserLoginDao userLoginDao;
    @Autowired
    UserInfoDao userInfoDao;
    @Autowired
    UserIdDao userIdDao;

    // 通过用户名密码登录
    @Override
    public UserInfo login(String username, String password) {
        String salt = userLoginDao.selectSalt(username);
        String passwordHash = passwordProcessing.hash(password, salt);
        UserLogin userLogin = userLoginDao.loginCheck(username, passwordHash);
        if (userLogin == null) {
            return null;
        } else {
            UserInfo userInfo = userInfoDao.selectUserInfoById(userLogin.getId());
            userLoginDao.updateLastTimeByName(username, new Date());
            return userInfo;
        }
    }

    // 通过id和密码登录
    @Override
    public UserInfo login(Integer id, String password) {
        // 通过id获取到用户名，调用前一个login方法。
        String username = userLoginDao.selectUserNameById(id);
        return login(username, password);
    }

    // 用户注册
    @Override
    public UserId resister(UserInfo user, String username, String password) {
        // 判断用户是否存在
        UserLogin check = userLoginDao.selectUserLoginByUserName(username);
        if (check != null) {
            return null;
        }
        // 获取一个空闲的id
//        Integer id = user
        // 对密码进行哈希计算
        HashMap<String, String> passwordHashMap = passwordProcessing.hash(password);
        // 读取哈希后的密码
        String passwordWithSalt = passwordHashMap.get("kw");
        // 读取盐值
        String salt = passwordHashMap.get("salt");
        // 创建对象
        UserLogin userLogin = new UserLogin(user.getId(), username, password, salt, new Date());
        userLoginDao.insertUserLogin(userLogin);
        return null;
    }

    // 办理会员
    @Override
    public Boolean setVIP(UserInfo userInfo, String vip) {
        int update = userInfoDao.updateVip(userInfo.getId(), vip);
        return update == 1;
    }
}
