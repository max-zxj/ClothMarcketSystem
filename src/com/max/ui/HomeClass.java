package com.max.ui;

import com.max.bean.Cloth;
import com.max.bean.Order;
import com.max.bean.OrderItem;
import com.max.service.ClothService;
import com.max.service.OrderService;
import com.max.service.impl.ClothServiceImpl;
import com.max.service.impl.OrderServiceImpl;
import com.max.utils.BusinessException;
import com.max.utils.DateUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomeClass extends BaseClass{
    private OrderService orderService = new OrderServiceImpl();
    private ClothService clothService = new ClothServiceImpl();
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
                    findAllOrders();
                    break;
                case "2":
                    findOrderById();
                    break;
                case "3":
                    try{
                        buyProducts();
                    }catch (BusinessException e){
                        print(e.getMessage());
                    }
                    break;
                case "4":
                    showProducts();
                    break;
                default:
                    print(getString("input.error"));
            }
        }
    }

    public void findOrderById(){
        print(getString("product.order.input.oid"));
        String oid = input.nextLine();
        Order order = orderService.findById(Integer.parseInt(oid));
        if(order != null){
            showOrder(order);
        }else{
            print(getString("product.order.error"));
        }
    }


    public void findAllOrders(){
        List<Order> orders = orderService.list();
        for(Order o:orders){
            showOrder(o);
        }
    }

    public void showOrder(Order order){
        print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        print("<id>"+order.getOrderId()+"\n");
        showOrderItems(order.getOrderItemList());
        print("<createdDate>"+order.getCreatedDare()+"\n");
        print("<userId>"+order.getUserId()+"\n");
        print("<status>"+order.getState()+"\n");
        print("<price>"+order.getTotalPrice()+"\n");
    }


    private void showOrderItems(List<OrderItem> orderItems){
        for(OrderItem orderItem:orderItems){
            print("-----------------");
            print("<clothId>"+orderItem.getCloth().getId()+"\n");
            print("<size>"+orderItem.getCloth().getSize()+"\n");
            print("<ClothNumber>"+orderItem.getNum()+"\n");
            print("<totalPrice>"+orderItem.getTotalPrice()+"\n");
            print("-----------------");
        }
    }



    private void showProducts(){
        ClothService clothService = new ClothServiceImpl();
        List<Cloth> list = clothService.list();
        for(Cloth cloth:list){
            print("-----------------");
            print("<id>"+cloth.getId()+"\n");
            print("<brand>"+cloth.getBrand()+"\n");
            print("<style>"+cloth.getStyle()+"\n");
            print("<color>"+cloth.getColor()+"\n");
            print("<size>"+cloth.getSize()+"\n");
            print("<num>"+cloth.getNum()+"\n");
            print("<price>"+cloth.getPrice()+"\n");
            print("<description>"+cloth.getDescription()+"\n");
        }

    }

    private void buyProducts() throws BusinessException {
        // build order
        boolean flag = true;
        int count = 0;
        List<OrderItem> list = new ArrayList<>();
        Date date = new Date();
        float totalPrice = 0;
        while(flag){
            print(getString("product.input.id"));
            String id = input.nextLine();
            print(getString("product.input.num"));
            int num = Integer.parseInt(input.nextLine());
            print(id);
            Cloth cloth = clothService.findById(id);
            if(cloth == null){
                print("111");
            }
            if(num > cloth.getNum()){
                throw new BusinessException(getString("product.num.error"));
            }
            cloth.setNum(cloth.getNum()-num);
            OrderItem orderItem = new OrderItem();
            orderItem.setCloth(cloth);
            orderItem.setNum(num);
            float price = num * cloth.getPrice();
            orderItem.setTotalPrice(price);
            orderItem.setId(count++);
            list.add(orderItem);
            totalPrice = totalPrice + price;
            print(getString("shopping.isFinished"));
            String isContinue = input.nextLine();
            if("2".equals(isContinue)){
                flag = false;
            }
        }
        Order order = new Order();
        order.setOrderItemList(list);
        order.setCreatedDare(DateUtils.toDate(date));
        order.setUserId(currentUser.getId());
        order.setUserId(orderService.getValidId());
        order.setTotalPrice(totalPrice);
        orderService.buyProduct(order);
        clothService.update();
        showProducts();
    }




}
