package com.company;

public class ShowMenuDK implements ShowMenu{
    @Override
    public void showMenu() {
        System.out.println("1) Vis menu");
        System.out.println("2) lav order");
        System.out.println("3) vis bestilling");
        System.out.println("4) Godkend bestilling");
        System.out.println("9) exit ");
    }

}