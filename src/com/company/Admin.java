package com.company;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class Admin {
    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;
    public static  Socket socket;
    public static AdminMainFrame frame;

    public static void connectToServer(){
        try {
            socket=new Socket("127.0.0.1",3399);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
        }catch (Exception e){e.printStackTrace();}
    }

    public static void addBooks(book book){
        PackageData pd=new PackageData();
        pd.setOperationType("Add_Book");
        pd.setBook(book);
        try {
            outputStream.writeObject(pd);
        }catch (Exception e){e.printStackTrace();}
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
    public static void deleteWithId(Long id){
        PackageData pd=new PackageData();
        pd.setOperationType("Delete_Books");
        pd.setId(id);
       // ArrayList<book> rooms=pd.getBooks();
        try {
            outputStream.writeObject(pd);
        }catch(Exception e){e.printStackTrace();}
    }

    public static void showAddPage(){
        Admin.frame.menu.setVisible(false);
        Admin.frame.listBooks.setVisible(false);
        Admin.frame.deletePage.setVisible(false);
        Admin.frame.addBooks.setVisible(true);
        Admin.frame.repaint();
    }
    public static void showListPage(){
        frame.menu.setVisible(false);
        frame.addBooks.setVisible(false);
        frame.deletePage.setVisible(false);
        frame.listBooks.setVisible(true);
        ArrayList<book> list = listBooks();
        Admin.frame.listBooks.updateArea(list);
    }

    public static void showDeletePage(){
        Admin.frame.menu.setVisible(false);
        Admin.frame.addBooks.setVisible(false);
        Admin.frame.listBooks.setVisible(false);
        ArrayList<book> list=listBooks();
        frame.deletePage.updateArea(list);
        Admin.frame.deletePage.setVisible(true);
        Admin.frame.repaint();
    }

    public static void showMenuPage(){
        Admin.frame.addBooks.setVisible(false);
        Admin.frame.listBooks.setVisible(false);
        Admin.frame.deletePage.setVisible(false);
        Admin.frame.menu.setVisible(true);
        Admin.frame.welcome.setVisible(false);
        Admin.frame.repaint();
    }

    public static void main(String[] args){
        connectToServer();

        frame = new AdminMainFrame();
        frame.setVisible(true);
    }
}
