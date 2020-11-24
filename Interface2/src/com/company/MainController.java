package com.company;

import com.company.Pizza;
import com.company.ShowMenu;
import com.company.ShowMenuDK;
import com.sun.codemodel.internal.JForEach;
import com.sun.tools.corba.se.idl.constExpr.Or;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    int choice = 0;
    Scanner sc = new Scanner(System.in);
    ShowMenu showMenu = new ShowMenuDK();
List<Pizza> pizzaList = getAllPizzasFromSource();
List<Orders> bestillinger = new ArrayList<>();

    public void runProgram() {
        showMenu.showMenu();
        while (choice!=9) {
            choice = sc.nextInt();
            switch (choice) {
                case 1: showPizzaMenu();break;
                case 2: createOrder();break;
                case 3: showOrders();break;
                case 4: confirmOrder();break;
                default:choice=9;break;
            }
        }
    }
public void showPizzaMenu() {
    for (Pizza p : pizzaList) {
        System.out.println(p);
    }
}
public void showOrders(){
    System.out.println(" viser bestillinger ");
        for (Orders orders:bestillinger) {
            System.out.println(orders.toString());
        }
    }

    //Createorder 1. Via alle pizza'er.
    private void createOrder() {
        //public Orders(String customerName, int phoneNumber)
        sc.nextLine();
        System.out.println("Hvad hedder du?");
        String customerName = sc.nextLine();
        System.out.println("nummer?");
        int phoneNumber = sc.nextInt();
        Orders orders = new Orders(customerName, phoneNumber);
        int lchoice = 0;
        while (lchoice != 99) {
            System.out.println("pizza nummer(99 er exit)");
            lchoice = sc.nextInt();
            if (lchoice != 99) {
                Pizza pizzaTemp = getPizzaById(lchoice);
                // Pizza returnPizza = new Pizza (pizzaTemp.getNumber(), pizzaTemp.getName(), pizzaTemp.getToppings(), pizzaTemp.getPrice());
                orders.addPizzaToOrder(pizzaTemp);
            }
        }

        System.out.println(orders.getPizzas().get(0).getPrice());
        System.out.println(orders.getPizzas());
        bestillinger.add(orders);
        showMenu.showMenu();
    }



    private void confirmOrder(){
    }

    private void editOrder(){
    }
    public ArrayList<Pizza> getAllPizzasFromDB(){
        ArrayList<Pizza> returnList = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet res = null;
        String sql = "";
        Pizza pizza = null;


        sql = "select * from pizza order by pizzaID";

        con = this.getConnection();
        try {
            pstmt = con.prepareStatement(sql);
            res = pstmt.executeQuery();
            while (res.next()) {
                // hente ting til by
                int PizzaID = res.getInt("PizzaID");
                String NameP  = res.getString("NameP");
                String Toppings = res.getString("Toppings");
                int price = res.getInt("price");
                //  PizzaID  int(255) NOT NULL PRIMARY KEY
                //	,NameP  VARCHAR(255) NOT NULL
                //  ,Toppings VARCHAR(255)
                //  ,Price    int(255)
                pizza = new Pizza(PizzaID, NameP, Toppings, price);
                //public Pizza(int number, String name, String toppings, int price)
                returnList.add(pizza);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return returnList;
    }

        public ArrayList<Pizza> getAllPizzasFromSource(){

        ArrayList<Pizza> returnList = new ArrayList<>();
        //Henter pizza fra en fil.
            // 1;Vesuvio;Tomatsauce, ost, skinke og oregano;57
            File file = new File("Resources/Pizza.csv");
            try {

                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String line = "";

                while ((line = br.readLine()) != null) {
                    String[] values = line.split(";");
                    Pizza pizza = new Pizza(Integer.valueOf(values[0]),values[1],values[2],Integer.valueOf(values[3]));
                    returnList.add(pizza);
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
            return returnList;
        }
        public Pizza getPizzaById(int id){
        Pizza returnPizza = null;
        if(id<=14) {
            for (Pizza pizza : pizzaList) {
                if (pizza.getNumber() == id) {
                    return pizza;
                }
            }
        }
        return returnPizza;
        }

    public Connection getConnection(){
        Connection con = null;
        //String addOn = "serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
        String url = "jdbc:mysql://localhost:3306/Mario";
        String user = "root";
        String pw = "";
        try {
            con = DriverManager.getConnection(url,user,pw);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }


}

