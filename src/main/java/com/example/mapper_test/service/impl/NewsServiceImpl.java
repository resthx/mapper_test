package com.example.mapper_test.service.impl;

import com.example.mapper_test.entity.News;
import com.example.mapper_test.service.NewsService;
import com.example.mapper_test.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* ClassName: NewsServiceImpl
* Description:
* date: Tue Jul 09 15:40:43 CST 2019
*/
@Service
public class NewsServiceImpl implements NewsService{
    @Autowired
    private NewsMapper newsMapper;

    @Override
    public News selectById(String id) {
        return newsMapper.selectById(id);
    }

    @Override
    public List<News> selectByPage(News news, int page, Integer limit) {
        return newsMapper.selectByPage(news,page,limit);
    }
}
