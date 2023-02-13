package com.max.utils;

import com.max.bean.Order;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OrderIO {
    private static List<Order> orders = new ArrayList<>();
    private static final String ORDER_FILE = "order.obj";

    public void add(Order order) throws BusinessException{
        if(orders.size() == 0){
            readOrders();
        }
        orders.add(order);
        // need write into file
    }

    public List<Order> list() throws BusinessException{
        if(orders.size() == 0){
            readOrders();
        }
        return orders;
    }

    public Order findByOrderId(int orderId) throws BusinessException{
        if(orders.size() == 0){
            readOrders();
        }
        Order order = null;
        int oid;
        for(Order o:orders){
            oid = o.getOrderId();
            if(oid == orderId){
                order = o;
                break;
            }
        }
        return order;
    }

    public boolean wirteOrders(){
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ORDER_FILE));
            out.writeObject(orders);
            out.close();
            return true;
        }catch(IOException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean readOrders(){
        try {
            FileInputStream fileIn = new FileInputStream(ORDER_FILE);
            if(fileIn.available() != 0){
                ObjectInputStream in = new ObjectInputStream(fileIn);
                orders = (List<Order>)in.readObject();
                in.close();
            }else{
                fileIn.close();
            }
            return true;
        }catch(IOException|ClassNotFoundException e){
            e.printStackTrace();
        }
        return false;
    }


}
