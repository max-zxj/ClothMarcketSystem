package com.max.bean;

import com.max.utils.OrderStateType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {
    private int orderId;
    private List<OrderItem> orderItemList = new ArrayList<>();
    private String createdDare;
    private float totalPrice;

    public OrderStateType getState() {
        return state;
    }

    public void setState(OrderStateType state) {
        this.state = state;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCreatedDare() {
        return createdDare;
    }

    public void setCreatedDare(String createdDare) {
        this.createdDare = createdDare;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    private int userId;
    private OrderStateType state = OrderStateType.UNPAID;


}
