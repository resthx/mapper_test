package com.example.mapper_test.entity;

/*import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;*/

/**
 * ClassName: User
 * Description:
 * date: 2019/6/22 13:53
 *
 * @author ji
 * @version 1.0
 * @since JDK 1.8
 */
/*@TableName("user")*/
public class User {
/*    @TableId(type = IdType.INPUT)*/
    private String id;
    private String name;
    private String mobile;
    private String img;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
