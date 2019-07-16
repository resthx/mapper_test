package com.example.mapper_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * ClassName: HelloController
 * Description:
 * date: 2019/7/2 9:37
 *
 * @author ji
 * @version 1.0
 * @since JDK 1.8
 */
@Controller
@RequestMapping
public class HelloController {

    @RequestMapping("/hello")
    public String hello(ModelAndView mv) {
        return "hello";
    }
    @RequestMapping("/path")
    public String path(HttpServletRequest request) throws IOException {
        String contextPath = request.getSession().getServletContext().getRealPath("test.txt");
        /*        InputStreamReader inputStreamReader = new InputStreamReader(resourceAsStream);*//**/
        File file = new File(contextPath);
        boolean exists = file.exists();
        return String.valueOf(exists);
    }
}
