package com.max.ui;

import com.max.bean.Cloth;
import com.max.service.ClothService;
import com.max.service.impl.ClothServiceImpl;

import java.util.List;

public class HomeClass extends BaseClass{
    public void show(){
        print("Welcome "+currentUser.getUsername()+"!");
        showProducts();
        boolean flag = true;
        while(flag){
            print(getString("home.function"));
            print(getString("info.select"));
            String select = input.nextLine();
            switch(select){
                case "0":
                    flag = false;
                    System.exit(0);
                case "1":

                    flag = false;
                    break;
                case "2":

                    flag = false;
                    break;
                case "3":

                    flag = false;
                    break;
                default:
                    print(getString("input.error"));


            }
        }

    }

    private void showProducts(){
        ClothService clothService = new ClothServiceImpl();
        List<Cloth> list = clothService.list();
        for(Cloth cloth:list){
            print("-----------------");
            print("<brand>"+cloth.getBrand()+"\n");
            print("<style>"+cloth.getStyle()+"\n");
            print("<color>"+cloth.getColor()+"\n");
            print("<size>"+cloth.getSize()+"\n");
            print("<num>"+cloth.getNum()+"\n");
            print("<price>"+cloth.getPrice()+"\n");
            print("<description>"+cloth.getDescription()+"\n");
        }

    }
}
