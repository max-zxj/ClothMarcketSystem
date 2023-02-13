package com.max.ui;
import com.max.bean.User;
import com.max.framwork.BeanFactory;

import java.util.ResourceBundle;
import java.util.Scanner;

public abstract class BaseClass {
    protected static Scanner input = new Scanner(System.in);
    protected static User currentUser;
    protected BeanFactory beanFactory = null;
    public BaseClass(){
        beanFactory= BeanFactory.init();
    }
    private static ResourceBundle r = ResourceBundle.getBundle("com.max.res.r");
    public static String getString(String key){
        return r.getString(key);
    }

    public static void println(String s){
        System.out.println(s);
    }
    public static void print(String s){
        System.out.println(s);
    }


}
