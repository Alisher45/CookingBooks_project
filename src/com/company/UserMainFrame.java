package com.company;
import javax.swing.*;
import java.awt.*;

public class UserMainFrame extends JFrame {
    public UserAdd addUser;
    public UserRegistr regitr;
    public UserMainMenu menu;
    public UserAddPage addOrders;
    public UserListPage listOrders;

    public UserMainFrame() {
        setTitle("USER");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        setLayout(null);
        setLocationRelativeTo(null);
        addUser = new UserAdd();
        addUser.setLocation(0, 0);
        addUser.setVisible(true);
        add(addUser);

        regitr=new UserRegistr();
        regitr.setLocation(0,0);
        regitr.setVisible(false);
        add(regitr);

        menu=new UserMainMenu();
        menu.setLocation(0,0);
        menu.setVisible(false);
        add(menu);

        addOrders = new UserAddPage();
        addOrders.setLocation(0,0);
        addOrders.setVisible(false);
        add(addOrders);

        listOrders= new UserListPage();
        listOrders.setLocation(0,0);
        listOrders.setVisible(false);
        add(listOrders);
    }
}



