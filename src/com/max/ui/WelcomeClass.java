package com.max.ui;

import com.max.utils.BusinessException;

public class WelcomeClass extends BaseClass{
    public void start(){
        print(getString("info.welcome"));
        boolean flag = true;
        while(flag){
            print(getString("info.login.reg"));
            print(getString("info.select"));
            String select = input.nextLine();
            switch(select){
                case "1":
                    try{
                        new LoginClass().login();
                        print(getString("login.success"));
                        flag = false;
                    } catch (BusinessException e){
                        print(getString("login.error"));
                    }
                    break;
                case "2":
                    try{
                        new RegisterClass().register();
                        print(getString("reg.success"));
                        flag = false;
                    }catch (BusinessException e){
                        print(getString("reg.error"));
                    }
                    print("register");
                    break;
                default:
                    print(getString("input.error"));
            }
        }
        HomeClass homeClass = new HomeClass();
        homeClass.show();
    }
}
