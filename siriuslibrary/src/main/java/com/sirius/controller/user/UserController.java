/*
 * UserController
 * 描述
 @author Sirius
 */
package com.sirius.controller.user;

import com.sirius.domain.UserInfo;
import com.sirius.service.impls.SecurityServiceImpl;
import com.sirius.service.interfaces.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class UserController {
    @Autowired
    SecurityServiceImpl securityServiceImpl;

    // 用户登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView run(ModelAndView modelAndView, HttpServletRequest request, String type, String username, String password){
        UserInfo check = securityServiceImpl.login(username, password);
        HttpSession session = request.getSession(true);
        if (check != null){
            session.setAttribute("user", check);
            modelAndView.addObject("username", username);
            modelAndView.setViewName("user_page");
        } else {
            modelAndView.setViewName("fail");
        }
        return modelAndView;
    }

    // 用户注册
    @RequestMapping(value = "/user/resister", method = RequestMethod.POST)
    public ModelAndView resister(String email, String sex, String tel, String username, String password){
        ModelAndView mv = new ModelAndView();
        // 创建用户个人信息对象
        UserInfo userInfo = new UserInfo();
        userInfo.setEmail(email);
        userInfo.setSex(sex);
        userInfo.setAddress("空");
        userInfo.setTel(tel);
        // 生成用户id（读书证）
        Integer id = securityServiceImpl.resister(userInfo, username, password);
        // 存入
        mv.addObject("id", id);
        // 显示页面
        mv.setViewName("show_id");
        return mv;
    }
}
