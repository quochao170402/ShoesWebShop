package com.github.shop.entity;

public class Bill {
    private Double price, delivery, vat, cost;

    public Bill() {
    }

    public Bill(Double price, Double delivery, Double vat, Double cost) {
        this.price = price;
        this.delivery = delivery;
        this.vat = vat;
        this.cost = cost;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDelivery() {
        return delivery;
    }

    public void setDelivery(Double delivery) {
        this.delivery = delivery;
    }

    public Double getVat() {
        return vat;
    }

    public void setVat(Double vat) {
        this.vat = vat;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "price=" + price +
                ", delivery=" + delivery +
                ", vat=" + vat +
                ", cost=" + cost +
                '}';
    }
}
