package com.max.service;

import com.max.bean.User;
import com.max.utils.BusinessException;

public interface UserService {
    public User register(User user) throws BusinessException;

    public User login(String username,String password) throws BusinessException;


}
