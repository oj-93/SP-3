package com.company;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MainControllerTest {

    @org.junit.Test
    public void getAllPizzasFromSource() {
        MainController mainController = new MainController();
        ArrayList<Pizza> pizzas = mainController.getAllPizzasFromSource();
    }

    @Test
    public void getAllPizzasFromDB() {
        MainController mainController = new MainController();
        ArrayList<Pizza> pizzas = mainController.getAllPizzasFromDB();
        int expected = 13;
        int actual = pizzas.size();
        assertEquals(expected, actual);

    }

    @Test
    public void getConnection() {
    }
}