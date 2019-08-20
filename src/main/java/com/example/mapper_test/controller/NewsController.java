package com.example.mapper_test.controller;

import com.example.mapper_test.entity.News;
import com.example.mapper_test.service.NewsService;
import com.example.mapper_test.util.RespDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
* ClassName: NewsController
* Description:
* date: Tue Jul 09 15:40:43 CST 2019
*/
@RestController
@RequestMapping("news")
public class NewsController {
    @Autowired
    private NewsService newsService;
    @RequestMapping("findById")
    public RespDate findById(@RequestParam("id") String id){
        News news = newsService.selectById(id);
        return RespDate.set(0,news,null);
    }
    @RequestMapping("find")
    public RespDate find(News news,@RequestParam("page") int page,@RequestParam(value = "limit",required = false) Integer limit){
        List<News> newss = newsService.selectByPage(news, page, limit);
        return RespDate.set(0,newss,null);
    }
}
