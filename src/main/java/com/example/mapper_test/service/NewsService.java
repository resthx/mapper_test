package com.example.mapper_test.service;

import com.example.mapper_test.entity.News;
import java.util.List;

/**
* ClassName: NewsService
* Description:
* date: Tue Jul 09 15:40:43 CST 2019
*/
public interface NewsService {
    News selectById(String id);
    List<News> selectByPage(News news,int page,Integer limit);
}
