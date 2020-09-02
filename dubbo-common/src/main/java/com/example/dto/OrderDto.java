package com.example.dto;

import java.io.Serializable;

public class OrderDto implements Serializable {

    private String orderId;
    private double price;
    private String name;

    public OrderDto(String orderId, double price, String name) {
        this.orderId = orderId;
        this.price = price;
        this.name = name;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
