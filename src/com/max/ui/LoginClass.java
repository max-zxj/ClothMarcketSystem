package com.max.ui;

import com.max.bean.User;
import com.max.service.UserService;
import com.max.service.impl.UserServiceImpl;
import com.max.utils.BusinessException;

public class LoginClass extends BaseClass{
    public void login() throws BusinessException{
        print(getString("input.username"));
        String username = input.nextLine();
        print(getString("input.password"));
        String password = input.nextLine();
        UserService userService = new UserServiceImpl();
        User user = userService.login(username,password);
        if(user != null){
            currentUser = user;
        }else{
            throw new BusinessException("login.error");
        }



    }
}
