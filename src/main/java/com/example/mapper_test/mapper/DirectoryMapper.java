package com.example.mapper_test.mapper;

import com.example.mapper_test.entity.Directory;
import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
* ClassName: DirectoryMapper
* Description:
* date: Fri Aug 09 09:28:43 CST 2019
*/
public interface DirectoryMapper extends BaseMapper<Directory> {
    List<Directory> selectByPage(Directory directory,@Param("page") int page,@Param("limit") Integer limit);
    Directory selectById(@Param("id") String id);
}