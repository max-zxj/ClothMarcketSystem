package com.max.bean;

public class Cloth {
    private String brand;
    private String id;
    private String style;
    private String color;
    private String size;
    private String description;
    private int num;
    private float price;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getStyle() {
        return style;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getBrand() {
        return brand;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Cloth{" +
                "brand='" + brand + '\'' +
                ", id='" + id + '\'' +
                ", style='" + style + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", description='" + description + '\'' +
                ", num=" + num +
                ", price=" + price +
                '}';
    }
}
