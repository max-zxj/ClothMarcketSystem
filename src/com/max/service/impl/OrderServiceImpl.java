package com.max.service.impl;

import com.max.bean.Order;
import com.max.service.OrderService;
import com.max.utils.BusinessException;
import com.max.utils.OrderIO;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderIO orderIO = new OrderIO();
    @Override
    public int getValidId() throws BusinessException{
        return list().size()+1;
    }
    @Override
    public void buyProduct(Order o) throws BusinessException {
        orderIO.add(o);
    }
    @Override
    public List<Order> list() throws BusinessException {
        return orderIO.list();
    }

    @Override
    public Order findById(int orderId) throws BusinessException {
        return orderIO.findByOrderId(orderId);
    }
}
