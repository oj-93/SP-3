package com.company;

import com.company.Pizza;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Orders {
    private List<Pizza> pizzas;
    private static int counter = 0;
    private int orderId;
    private LocalTime orderTime;
    private String customerName;
    private int phoneNumber;
    private int price = 0;


    public Orders(String customerName, int phoneNumber) {
        pizzas = new ArrayList<>();
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.orderTime = LocalTime.now();
       this.orderId = counter;
       counter++;

    }
    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public int getOrderId() {
        return orderId;
    }

    public LocalTime getOrderTime() {
        return orderTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void addPizzaToOrder(Pizza pizza){
        pizzas.add(pizza);

    }

    public int getPrice(){
        int sum = 0;
        for (Pizza pizza:pizzas) {
         sum+=pizza.getPrice();
        }
        return sum;
    }

    @Override
    public String toString() {
        return orderId + "," + customerName + "," + phoneNumber + "," + pizzas + ","+ getPrice();
    }
}
