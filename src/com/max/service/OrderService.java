package com.max.service;

import com.max.bean.Order;
import com.max.utils.BusinessException;

import java.util.List;

public interface OrderService {
    public void buyProduct(Order o) throws BusinessException;
    public List<Order> list() throws BusinessException;
    public Order findById(int orderId) throws BusinessException;
    public int getValidId() throws BusinessException;

}
