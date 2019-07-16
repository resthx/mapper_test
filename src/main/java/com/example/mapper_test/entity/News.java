package com.example.mapper_test.entity;

/**
 * ClassName: News
 * Description:
 * date: 2019/7/9 15:38
 *
 * @author ji
 * @version 1.0
 * @since JDK 1.8
 */
public class News {
    private String id;
    private String img;
    private Integer click;
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
