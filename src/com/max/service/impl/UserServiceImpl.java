package com.max.service.impl;

import com.max.bean.User;
import com.max.service.UserService;
import com.max.utils.BusinessException;
import com.max.utils.EmptyUtils;
import com.max.utils.UserIO;

public class UserServiceImpl implements UserService {
    @Override
    public User register(User user) throws BusinessException {
        UserIO userIO = new UserIO();
        userIO.add(user);
        userIO.writeUsers();
        return null;
    }
    @Override
    public User login(String username, String password) throws BusinessException{
        if(EmptyUtils.isEmpty(username)){
            throw new BusinessException("username.notnull");
        }
        if(EmptyUtils.isEmpty(password)){
            throw new BusinessException("password.notnull");
        }
        UserIO userIO = new UserIO();
        User user = userIO.findByUsernameAndPassword(username,password);
        return user;
    }



}
