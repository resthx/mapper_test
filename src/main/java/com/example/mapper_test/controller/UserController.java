package com.example.mapper_test.controller;

import com.example.mapper_test.entity.User;
import com.example.mapper_test.service.UserService;
import com.example.mapper_test.util.EmptyUtil;
import com.example.mapper_test.util.RespDate;
import com.example.mapper_test.util.StringTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
* ClassName: UserController
* Description:
* date: Tue Jul 02 16:20:16 CST 2019
*/
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("user_list.html")
    public ModelAndView userList(){
        ModelAndView modelAndView = new ModelAndView("admin/user/user_list");
        return modelAndView;
    }
    @RequestMapping("user_update.html")
    public ModelAndView user_update(@RequestParam(value = "id",required = false)String id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/user/user_update");
        User user = new User();
        if (!EmptyUtil.isEmpty(id)){
            user = userService.selectById(id);
            modelAndView.addObject("user",user);
        }else {
            modelAndView.addObject("user",user);
        }
        return modelAndView;
    }
    @RequestMapping("findById")
    public RespDate findById(@RequestParam("id") String id) throws InterruptedException {
        User user = userService.selectById(id);
        Thread.sleep(50000);
        return RespDate.set(0,user,null);
    }
    @RequestMapping("find")
    public RespDate find(User user,@RequestParam("page") int page,@RequestParam(value = "limit",required = false) Integer limit){
        List<User> users = userService.selectByPage(user, page, limit);
        int count = userService.selectCount(user);
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("users",users);
        resultMap.put("count",count);
        return RespDate.set(0,resultMap,null);
    }
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public RespDate update(User user){
        int i = 0;
        if (EmptyUtil.isEmpty(user.getId())){
            user.setId(StringTool.getUUID());
            i = userService.insertUser(user);
        }else {
            i = userService.updateUser(user);
        }
        if (i==1){
            return RespDate.set(0,null,null);
        }else {
            return RespDate.set(-1,null,null);
        }
    }
}
