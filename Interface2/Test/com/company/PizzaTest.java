package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class PizzaTest {

    @Test
    public void testToString() {
        Pizza pizza = new Pizza (1, "Vesuvio","Tomatsauce, ost, skinke oregano",57);
        System.out.println(pizza);
    }
}