/*
 * SecurityService
 * 描述
 @author Sirius
 */
package com.sirius.service.interfaces;

import com.sirius.domain.UserId;
import com.sirius.domain.UserInfo;

public interface SecurityService {
    // 用户名密码登录
    UserInfo login(String username, String password);
    // id和密码登录
    UserInfo login(Integer id, String password);
    // 用户注册
    UserId resister(UserInfo user, String username, String password);
    // 办理会员
    Boolean setVIP(UserInfo userInfo, String vip);
}
