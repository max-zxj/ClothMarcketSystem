package com.max.ui;

import com.max.bean.User;
import com.max.service.UserService;

public class RegisterClass extends BaseClass{
    private UserService userService;
    public RegisterClass(){
        userService = (UserService) beanFactory.getBean("UserServece");
    }
    public void register(){
        print(getString("input.username"));
        String username = input.nextLine();
        print(getString("input.password"));
        String password = input.nextLine();
        User user = new User(username,password);
        userService.register(user);
    }

}
