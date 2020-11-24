package com.company;
//pizzaNumber;PizzaName;ingredients;price

public class Pizza{


   private String name;
    private String toppings;
    private int number;
     private int price;


    public Pizza(int number, String name, String toppings, int price) {
        this.name = name;
        this.toppings = toppings;
        this.number = number;
        this.price = price;


    }

    public String getName() {
        return name;
    }

    public String getToppings() {
        return toppings;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    public int getNumber() {
        return number;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return number + ";" + name + ";" + toppings + ";" + price;
    }

    }

