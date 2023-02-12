package com.max.utils;

public class EmptyUtils {
    public static boolean isEmpty(String s){
        if(null == s || "".equals(s)){
            return false;
        }else{
            return true;
        }
    }
}
