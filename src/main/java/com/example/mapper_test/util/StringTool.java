package com.example.mapper_test.util;

import java.util.UUID;

/**
 * ClassName: StringTool
 * Description:
 * date: 2019/8/20 14:26
 *
 * @author ji
 * @version 1.0
 * @since JDK 1.8
 */
public class StringTool {
    public static String getUUID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("-", "").toLowerCase();
    }
}
