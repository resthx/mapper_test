package com.example.mapper_test.entity;

/**
 * ClassName: Account
 * Description:
 * date: 2019/6/28 9:15
 *
 * @author ji
 * @version 1.0
 * @since JDK 1.8
 */
public class Account {
    private Integer id;
    private String password;
    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
