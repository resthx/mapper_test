package com.example.mapper_test.service.impl;

import com.example.mapper_test.entity.Directory;
import com.example.mapper_test.service.DirectoryService;
import com.example.mapper_test.mapper.DirectoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* ClassName: DirectoryServiceImpl
* Description:
* date: Fri Aug 09 09:28:43 CST 2019
*/
@Service
public class DirectoryServiceImpl implements DirectoryService{
    @Autowired
    private DirectoryMapper directoryMapper;

    @Override
    public Directory selectById(String id) {
        return directoryMapper.selectById(id);
    }

    @Override
    public List<Directory> selectByPage(Directory directory, int page, Integer limit) {
        return directoryMapper.selectByPage(directory,page,limit);
    }
}
