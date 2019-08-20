package com.example.mapper_test.controller;

import com.example.mapper_test.entity.Directory;
import com.example.mapper_test.service.DirectoryService;
import com.example.mapper_test.util.RespDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
* ClassName: DirectoryController
* Description:
* date: Fri Aug 09 09:28:43 CST 2019
*/
@RestController
@RequestMapping("directory")
public class DirectoryController {
    @Autowired
    private DirectoryService directoryService;
    @RequestMapping("findById")
    public RespDate findById(@RequestParam("id") String id){
        Directory directory = directoryService.selectById(id);
        return RespDate.set(0,directory,null);
    }
    @RequestMapping("find")
    public RespDate find(Directory directory,@RequestParam("page") int page,@RequestParam(value = "limit",required = false) Integer limit){
        List<Directory> directorys = directoryService.selectByPage(directory, page, limit);
        return RespDate.set(0,directorys,null);
    }
}
