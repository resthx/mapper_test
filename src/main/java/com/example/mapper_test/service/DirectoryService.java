package com.example.mapper_test.service;

import com.example.mapper_test.entity.Directory;
import java.util.List;

/**
* ClassName: DirectoryService
* Description:
* date: Fri Aug 09 09:28:43 CST 2019
*/
public interface DirectoryService {
    Directory selectById(String id);
    List<Directory> selectByPage(Directory directory,int page,Integer limit);
}
