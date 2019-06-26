package com.example.mapper_test.util;

/**
 * ClassName: RespDate
 * Description:
 * date: 2019/6/22 15:13
 *
 * @author ji
 * @version 1.0
 * @since JDK 1.8
 */
public class RespDate {
    private int code;
    private Object data;
    private String msg;
    public static RespDate set(int code,Object data,String msg){
        RespDate respDate = new RespDate();
        respDate.setCode(code);
        respDate.setData(data);
        respDate.setMsg(msg);
        return respDate;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
