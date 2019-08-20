package com.example.mapper_test.entity;

import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

/**
 * ClassName: Role
 * Description:
 * date: 2019/8/9 9:11
 *
 * @author ji
 * @version 1.0
 * @since JDK 1.8
 */
public class Directory{
    @TableId("id")
    private String id;
    private String name;
    private String code;
    private String value;
    private Date createTime;
    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
