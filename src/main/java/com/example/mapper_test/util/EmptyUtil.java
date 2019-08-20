package com.example.mapper_test.util;

/**
 * ClassName: EmptyUtil
 * Description:
 * date: 2019/8/19 15:14
 *
 * @author ji
 * @version 1.0
 * @since JDK 1.8
 */
public class EmptyUtil {
    public static boolean isEmpty(String s){
        if (s==null){
            return true;
        }
        if (s.trim()==""){
            return true;
        }
        return false;
    }
}
