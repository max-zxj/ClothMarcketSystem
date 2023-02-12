package com.max.ui;

import com.max.bean.User;
import com.max.service.UserService;
import com.max.service.impl.UserServiceImpl;
import com.max.utils.BusinessException;

public class RegisterClass extends BaseClass{
    public void register(){
        print(getString("input.username"));
        String username = input.nextLine();
        print(getString("input.password"));
        String password = input.nextLine();
        User user = new User(username,password);
        UserService userService = new UserServiceImpl();
        userService.register(user);


    }

}
