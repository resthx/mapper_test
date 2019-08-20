package com.example.mapper_test.mapper;

import com.example.mapper_test.entity.News;
import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
* ClassName: NewsMapper
* Description:
* date: Tue Jul 09 15:40:43 CST 2019
*/
public interface NewsMapper extends BaseMapper<News> {
    List<News> selectByPage(News news,@Param("page") int page,@Param("limit") Integer limit);
    News selectById(@Param("id") String id);
}