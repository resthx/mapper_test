package com.example.mapper_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName: AdminController
 * Description:
 * date: 2019/7/11 16:44
 *
 * @author ji
 * @version 1.0
 * @since JDK 1.8
 */
@Controller
@RequestMapping("admin")
public class AdminController {
    @RequestMapping("admin")
    public String adminIndex(){
        return "admin/index";
    }
    @RequestMapping("welcome.html")
    public String adminWelcome(){
        return "admin/welcome";
    }
    @RequestMapping("user/user_update.html")
    public String user_update(){
        return "admin/user/user_update";
    }
}
