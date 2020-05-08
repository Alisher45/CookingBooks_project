package com.company;
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class User {
    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;
    public static UserMainFrame frame;
    public static Socket  socket;
    public static String accaunt=null;

    private static  ArrayList<UserData> users;

    public static void connectToServer(){
        try{
            socket=new Socket("127.0.0.1",3399);
            outputStream=new ObjectOutputStream(socket.getOutputStream());
            inputStream=new ObjectInputStream((socket.getInputStream()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void addUser(UserData user){
        PackageData pd=new PackageData();
        pd.setOperationType("Add_User");
        pd.setUser(user);
        try {
            outputStream.writeObject(pd);
        }catch (Exception e){e.printStackTrace();}
        }

    public static ArrayList<Orders> listOrders(){
        ArrayList<Orders> orders=new ArrayList<>();
        PackageData pd=new PackageData();
        pd.setOperationType("List_Orders");
        pd.setOrders(orders);
        try {
            outputStream.writeObject(pd);
            if((pd = (PackageData) inputStream.readObject())!=null){
                orders =pd.getOrders();
            }
        }catch (Exception e){e.printStackTrace();}
        return orders;
    }


    public static ArrayList<UserData> listUser(){
        ArrayList<UserData> users=new ArrayList<>();
        PackageData pd=new PackageData();
        pd.setOperationType("List_Users");
        pd.setUsers(users);
        try {
            outputStream.writeObject(pd);
            if((pd = (PackageData) inputStream.readObject())!=null){
                users=pd.getUsers();
                for(UserData ud : users)
                    System.out.println(ud);
            }
        }catch (Exception e){e.printStackTrace();}
        return users;
    }
    public static ArrayList<book> listBooks(){
        ArrayList<book> books=new ArrayList<>();
        PackageData pd=new PackageData();
        pd.setOperationType("List_Books");
        pd.setBooks(books);
        try {
            outputStream.writeObject(pd);
            if((pd = (PackageData) inputStream.readObject())!=null){
                books=pd.getBooks();
            }
        }catch (Exception e){e.printStackTrace();}
        return books;
    }

    public static void addOrders(Orders orders){
        PackageData pd=new PackageData();
        ArrayList<Orders> orders1 = new ArrayList<>();
        orders1.add(orders);
        pd.setOperationType("Add_Orders");
        pd.setOrders(orders1);
        try {
            outputStream.writeObject(pd);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void showRegistrPage(){
        User.frame.addUser.setVisible(false);
        User.frame.regitr.setVisible(true);
        User.frame.menu.setVisible(false);
        User.frame.repaint();
    }

    public static void myLogin(String login){
        accaunt=login;
    }

    public static void showListPage(){
        User.frame.menu.setVisible(false);
        User.frame.addOrders.setVisible(false);
        User.frame.listOrders.setVisible(true);
        ArrayList<Orders>list=listOrders();
        frame.listOrders.updateArea(list);
        User.frame.repaint();
    }

    public static void showMainMenu() {
        User.frame.addUser.setVisible(false);
        User.frame.regitr.setVisible(false);
        User.frame.menu.setVisible(true);
        User.frame.repaint();
    }

    public static void showMenuPage() {
        User.frame.addUser.setVisible(true);
        User.frame.regitr.setVisible(false);
        User.frame.menu.setVisible(false);
        User.frame.repaint();
    }

    public static void main(String[] args){
        connectToServer();

        frame = new UserMainFrame();
        frame.setVisible(true);
    }
}
