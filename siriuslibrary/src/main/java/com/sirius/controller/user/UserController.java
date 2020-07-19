/*
 * UserController
 * 描述
 @author Sirius
 */
package com.sirius.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
public class UserController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView run(ModelAndView modelAndView, String type, String username, String password){
        modelAndView.addObject("username", username);
        modelAndView.setViewName("user_page");
        return modelAndView;
    }
}
