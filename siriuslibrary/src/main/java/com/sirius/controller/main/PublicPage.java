/*
 * PublicPage
 * 公共页面加载控制器类
 @author Sirius
 */
package com.sirius.controller.main;

import com.sirius.service.impls.PublicPageImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class PublicPage {
    @Autowired
    private PublicPageImpl publicPageImpl;  // 自动注入service

    @RequestMapping("/")    // 主页面控制器
    public ModelAndView mainPage(ModelAndView mv){
        Date showTime = new Date(); // 页面访问时间
        String nums = publicPageImpl.enterNum();    // 获取访问数量
        mv.addObject("time", showTime);
        mv.addObject("total", nums);
        mv.setViewName("index");
        return mv;
    }
    @RequestMapping("/resister")
    public ModelAndView resisterPage(ModelAndView mv){
        mv.setViewName("resister");
        return mv;
    }
}
